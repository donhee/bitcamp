// 예외 처리 후 마무리 작업 - try-with-resources
package step21.ex03;

import java.io.FileReader;
import java.util.Scanner;

public class Exam06_4 {
    
    static class A {}
    
    static class B implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("B 클래스의 자원을 해제하였습니다.");
        }
    }
    
    static void m() throws Exception {
        try (
                //A obj = new A(); // 컴파일 오류
                B obj2 = new B(); // OK
            ) { 
            System.out.println("try 블록 실행...");
        } 
        // finally 블록에서 B의 close()를 호출하지 않아도,
        // 자동으로 호출될 것이다.
    }
    
    public static void main(String[] args) throws Exception {
        m();
    }
}
