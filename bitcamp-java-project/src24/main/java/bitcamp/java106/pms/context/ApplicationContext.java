// 미니 IoC 컨테이너
package bitcamp.java106.pms.context;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bitcamp.java106.pms.annotation.Component;

public class ApplicationContext {
    // 클래스 이름으로 객체를 저장할 수 있도록 Map 을 사용한다.
    private HashMap<String,Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName, Map<String,Object> beans) throws Exception { 
        // 다른 맵에 들어있는 객체를 이 컨테이너에 복사한다.
        if (beans != null) {
            objPool.putAll(beans);
        }
        
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        File dir = new File(classLoader.getResource(
                packageName.replace(".", "/")).getPath()); 
        if (!dir.isDirectory())
            return;
        findAndInstantiateClasses(dir, packageName); // 디렉토리가 맞다면 클래스를 찾아서 인스턴스를 생성해라 
    }

    private void findAndInstantiateClasses(File dir, String packageName) throws Exception {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if ( pathname.isDirectory() ||         // 디렉토리 이거나
                        (pathname.getName().endsWith(".class") &&  // .class 파일이거나 
                        !pathname.getName().contains("$")) ) { // 단 중첩 클래스 제외
                    return true;
                }
                return false;
            }
            
        });
        for (File f : files) {
            if (f.isDirectory()) { // 디렉토리라면
                findAndInstantiateClasses(f, packageName + "." + f.getName()); // 클래스이름을찾아라
                continue;
            } 
        
            String classname = f.getName();
            // 클래스 정보를 알아내고
            Class clazz = Class.forName(packageName + "." + 
                    classname.substring(0, classname.length() - 6));
            
            // 이미 해당 타입의 객체가 생성되어 있다면 다시 생성하지 않는다.
            if (objPool.get(clazz.getName()) != null)
                continue;
            
            Object obj = createObject(clazz); 
            if (obj != null) { // 만들었다면
                this.objPool.put(getComponentName(clazz), obj); // 객체를 저장하는데 클래스이름을 key값으로 쓰겟다. 
            }
            
        }
    }
    
    private String getComponentName(Class clazz) throws Exception {
        Component anno = (Component) clazz.getAnnotation(Component.class);
        String label = anno.value();
        if (label.length() == 0)
            return clazz.getName();
        return label;
    
    }
    
    private Object createObject(Class clazz) throws Exception {
        
        if (!isComponent(clazz))
            return null;
        
        try {
            // 파라미터가 없는 기본 생성자를 찾는다.
            clazz.getConstructor();
            return clazz.newInstance(); // 기본 생성자를 호출하여 객체를 생성한다.
        } catch (Exception e) {
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                Object obj = callConstructor(constructor);
                if (obj != null)
                    return obj;
            }
            return null;
        }
    }
    
    private boolean isComponent(Class clazz) throws Exception {
     // 애노테이션 타입을 지정하여 해당 클래스에서 @Component 애노테이션 정보를 추출한다.
        Component anno = (Component) clazz.getAnnotation(Component.class);
        if (anno == null)
            return false;
        return true;
    }
    
    private Object callConstructor(Constructor constructor) throws Exception {
        if (containsDefaultType(constructor)) // 생성자의 파라미터 타입이 기본 타입을 포함하고 있으면 null
            return null;
        
        Class[] paramTypes = constructor.getParameterTypes();
        
        // 파라미터 타입에 해당하는 값을 보관하는 저장소
        ArrayList<Object> paramValues = new ArrayList<>();
        for (Class paramType : paramTypes) {
            paramValues.add(findObject(paramType)); // 파라미터 값을 준비
        }
        
        // 파라미터 값이 준비되었기 때문에 
        // 준비한 파라미터 값을 가지고 생성자를 호출하여 인스턴스를 만들어 리턴한다.
        return constructor.newInstance(paramValues.toArray());
    }
    
    private Object findObject(Class clazz) throws Exception{
        Object obj = objPool.get(clazz.getName());
        if (obj != null) { // 그 클래스 타입과 일치하는 객체가 있다면 그 객체를 리턴!
            return obj; 
        }  
        // 없으면
        // 만약 objPool에 그런 타입의 객체가 없다면 새로 만들어 리턴!
        obj = clazz.newInstance();
        objPool.put(clazz.getName(), obj); // objPool에 저장시켜놔라
        return obj;
    }
    
    private boolean containsDefaultType(Constructor constructor) {
        Class[] defaultTypes = {
                byte.class ,short.class ,int.class ,long.class ,float.class 
               ,double.class ,boolean.class ,char.class ,Byte.class ,Short.class 
               ,Integer.class ,Long.class ,Float.class ,Double.class,Character.class ,String.class
        };
    
        // 1) 생성자의 파라미터 정보를 꺼낸다.
        Class[] paramTypes = constructor.getParameterTypes();
    
        // 2) 생성자의 파라미터 타입이 primitive 타입이거나 Wrapper, String 일 경우
        //    이 생성자를 호출할 때 해당 값을 줘서 호출해야 한다.
        //    문제는 어떤 값을 줘야 하는지, 예를 들어 int를 원한다면
        //    int 값으로 얼마를 줘야 하는지 여기서 결정할 수 없다.
        //    그래서 이런 생성자로는 객체를 생성할 수 없다.
        //    이런 생성자인지 검사한다.
        for (Class paramType : paramTypes) {
            for (Class defaultType : defaultTypes) {
                if (paramType == defaultType)
                    return true;
            }
        }
        return false;
    }
    
    public Object getBean(String name) {
        return objPool.get(name);
    }

    public Object getBean(Class type) {
        Collection objList = objPool.values();
        for (Object obj : objList) {
            if (obj.getClass() == type)
                return obj;
        }
        return null;
    }
    
    
}

// ver 24 - 타입으로 객체를 찾는 getBean() 메서드 추가