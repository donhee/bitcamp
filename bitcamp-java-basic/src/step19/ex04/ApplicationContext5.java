// 중첩 클래스를 제외한 .class 파일만 추출한다.
package step19.ex04;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext5 {
    private ArrayList<String> list = new ArrayList<>();

    public ApplicationContext5(String packageName) { // 패키지 이름
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (!dir.isDirectory())
            return;
        findFiles(dir, packageName);
    }
    // 파일 경로 ex) C:\Users\doni\git\bitcamp\bitcamp-java-basic\bin\step19\ex03\Exam06.class 이라고 가정
    // 파일 경로에서 "패키지명"과 "클래스"명을 추출할 수 없다.
    // 그래서 파일을 찾을 때 패키지 이름을 따로 관리한다.   그래서 따로 파라미터로 받는다
    private void findFiles(File dir, String packageName) {
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
            if (f.isDirectory()) { // 하위 폴더의 파일을 가져온다. 
                findFiles(f, packageName + "." + f.getName());
            } else {
                String classname = f.getName();
                
                this.list.add(packageName + "." + classname.substring(0, classname.length() - 6));
            }
        }
    }
    
    // list를 리턴해주는 getFiles() 메소드 만든다.
    public List<String> getFiles() {
        return this.list;
    }



}
