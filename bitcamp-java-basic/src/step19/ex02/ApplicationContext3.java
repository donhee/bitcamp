// 디렉토리 경로 대신 패키지 이름을 입력 받아
// 해당 패키지의 파일 목록을 알아내기
package step19.ex02;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext3 {
    private ArrayList<File> list = new ArrayList<>();

    public ApplicationContext3(String packageName) { // 패키지 이름
        // 1) 패키지 이름에 포함된 .을 파일 경로의 /로 변경한다.
        String path = packageName.replace(".", "/");
        
        // 2) 해당 경로의 디렉토리를 classpath에서 찾아 실제 경로를 알아낸다.
        // 프로그램과 관련된 파일을 일반 경로에 두는 것 보다
        // JVM이 알고 있는 경로에 두는 것이 해당 파일을 보다 쉽게 찾을 수 있다.
        // 왜냐하면,
        // 파일을 JVM이 모르는 특정 경로에 두면,
        // 그 파일을 찾기 위해서는 소스 코드에 그 특정 경로를 지정해야 한다.
        // 만약 프로그램을 다른 OS에 배포하게 되어서 그 경로가 달라지면
        // 또 소스 코드를 변경해야 하는 번거로움이 발생하기 때문이다.
        
        // CLASSPATH를 뒤져서 파일을 찾아줄 객체를 얻는다.
        // => ClassLoader
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        // 클래스 로더를 이용하여 특정 패키지나 클래스의 절대 경로를 알아낸다.
        //    => 클래스 로더는 디렉토리나 파일을 찾을 때 JVM에 지정된 CLASSPATH에서 찾는다.
        //       따라서 프로그램을 작성할 때 해당 패키지나 파일이 있는 경로를
        //       코드에 지정할 필요가 없어 편리하다.
        //    => 자원이 있는 경로를 지정할 때 . 대신 / 를 사용하라!!
        //       getResource() 가 리턴하는 것은 찾은 자원
        //    => 같은 경로의 자원이 여러 디렉토리에 중복해서 있을 때는
        //       getResources()를 호출하여 여러 개의 경로 정보를 받아라!
        //    => 자원의 경로 정보를 담고 있는 URL 객체를 리턴한다.
        URL url = classLoader.getResource(path);
        
        // 3) URL에서 실제 경로를 뽑아 File 객체를 생성한다.
        File dir = new File(url.getPath());
        
        // 4) 해당 파일의 경로가 디렉토리를 가리키고 있다면,
        //    그 디렉토리의 파일 목록을 알아낸다.
        if (!dir.isDirectory())
            return;
        findFiles(dir);
    }

    private List<File> findFiles(File dir) {
        File[] files = dir.listFiles();
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
