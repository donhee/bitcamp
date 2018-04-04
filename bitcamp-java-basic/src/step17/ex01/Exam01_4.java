// 클래스의 종류 : 로컬(Local) 클래스
package step17.ex01;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_4 {
    
    public static void main(String[] args) throws Exception {
        // local class
        // => 특정 메서드 안에서만 사용할 클래스라면 그 메서드 안에 클래스를 정의하라!
        // => 메서드 안에 정의된 클래스를 "로컬 클래스(local class)"라 부른다.
        class JavaFilter implements FilenameFilter {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".java")) // 파일 이름이 .java로 끝나면
                    return true; // 조회 결과에 포함시켜라
                return false; // 조회 결과에서 제외하라!
            }
        }
        
        File dir = new File(".");
        
        // local class의 인스턴스를 생성한다.
        JavaFilter javafilter = new JavaFilter();

        // local class의 인스턴스를 필터로 사용하여 디렉토리 안의 목록을 추출한다.
        String[] names = dir.list(javafilter);
        
        for (String name : names)
            System.out.println(name);
    }
}
