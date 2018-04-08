// 객체를 저장할 때 클래스 이름으로 저장하고, 클래스 이름으로 꺼낼 수 있다.
package step19.ex07;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class ApplicationContext8 {
    // 클래스 이름으로 객체를 저장할 수 있도록 Map 을 사용한다.
    private HashMap<String,Object> objPool = new HashMap<>();
    
    
    public ApplicationContext8(String packageName) throws Exception { 
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        File dir = new File(url.getPath());
        if (!dir.isDirectory())
            return;
        findClasses(dir, packageName);
    }
    // 파일 경로 ex) C:\Users\doni\git\bitcamp\bitcamp-java-basic\bin\step19\ex03\Exam06.class 이라고 가정
    // 파일 경로에서 "패키지명"과 "클래스"명을 추출할 수 없다.
    // 그래서 파일을 찾을 때 패키지 이름을 따로 관리한다.   그래서 따로 파라미터로 받는다
    private void findClasses(File dir, String packageName) throws Exception {
        File[] files = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if ( pathname.isDirectory() || // 디렉토리 이거나
                        (pathname.getName().endsWith(".class") &&  // .class 파일이거나 
                        !pathname.getName().contains("$")) ) { // 단 중첩 클래스 제외
                    return true;
                }
                return false;
            }
            
        });
        for (File f : files) {
            if (f.isDirectory()) { // 디렉토리라면
                findClasses(f, packageName + "." + f.getName()); // 클래스이름을찾아라
                continue;
            } 
        
            String classname = f.getName();
            // 클래스 정보를 알아내고
            Class clazz = Class.forName(packageName + "." + classname.substring(0, classname.length() - 6));
            Object obj = createObject(clazz); 
            if (obj != null) {
                this.objPool.put(clazz.getName(), obj); // 객체를 저장하는데 클래스이름을 key값으로 쓰겟다. 
            }
            
        }
    }
    
    private Object createObject(Class clazz) {
        try {
            // 파라미터가 없는 기본 생성자를 찾는다.
            Constructor defaultconstructor = clazz.getConstructor();
            return clazz.newInstance(); // 기본 생성자를 호출하여 객체를 생성한다.
        } catch (Exception e) {
            return null;
        }
    }
    
    public Object getBean(String name) {
        return objPool.get(name);
    }



}
