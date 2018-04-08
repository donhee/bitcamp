// IoC 컨테이너 만들기 - 2) 특정 패키지의 파일 목록 알아내기
package step19.ex02;

import java.io.File;
import java.util.List;

// => ClassLoader로 자바 classpath를 검색하여 해당 패키지를 찾는다.
public class Exam05 {

    public static void main(String[] args) throws Exception {
        // 1) 패키지 경로를 따로 준비하지 않는다.
        //File packageDir = new File("C:\\Users\\doni\\git\\bitcamp\\bitcamp-java-basic\\bin\\step19");
        
        // 2) 해당 패키지의 파일 목록을 가져오기
        ApplicationContext3 appContext = new ApplicationContext3("step19");
        List<File> files = appContext.getFiles();
        for (File f : files) {
                System.out.println(f.getCanonicalPath());
        }
    }
        
}
