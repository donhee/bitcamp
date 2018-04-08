// 중첩 클래스를 제외한 .class 파일만 추출한다.
package step19.ex03;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext4 {
    private ArrayList<File> list = new ArrayList<>();

    public ApplicationContext4(String packageName) { // 패키지 이름
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (!dir.isDirectory())
            return;
        findFiles(dir);
    }

    private List<File> findFiles(File dir) {
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
                findFiles(f);
            } else {
                this.list.add(f);
            }
        }
        return list;
    }
    
    // list를 리턴해주는 getFiles() 메소드 만든다.
    public List<File> getFiles() {
        return this.list;
    }



}
