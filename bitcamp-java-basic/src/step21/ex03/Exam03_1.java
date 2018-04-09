// 던지는 예외를 메서드에 선언하기 - 모두 나열하기
package step21.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam03_1 {
    
    // 메서드에서 발생되는 모든 예외를 나열하기
    static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
        if (i == 0)
            throw new Exception();
        else if (i == 1)
            throw new RuntimeException();
        else if (i == 2)
            throw new SQLException();
        else 
            throw new IOException();
    }
    
    // 공통 분모를 사용하여 퉁치는 방법
    // => 메서드에서 발생하는 예외의 공통 수퍼 클래스를 지정하면 된다.
    // => 호출자에게 어떤 오류가 발생하는지 정확하게 알려주는 것이 유지보수에 도움이 된다.
    //    따라서 가능한 그 메서드에서 발생하는 예외를 모두 나열하라!!
    static void m2(int i) throws Exception {
        if (i == 0)
            throw new Exception();
        else if (i == 1)
            throw new RuntimeException();
        else if (i == 2)
            throw new SQLException();
        else 
            throw new IOException();
    }
    
    // java.lang.Error 계열의 오류를 던질 때는 어떤 오류를 던지는지 선언하지 않아도 된다.
    // 물론 선언해도 된다. // 생략해도 된다.
    static void m3() {
        throw new Error(); // OK! 하지만 이 계열의 클래스를 사용하지 마라!
        // 왜? JVM 관련 오류일 때 사용하는 클래스이다.
    }
    
    static void m4() throws Exception {
        throw new Exception(); // OK! 보통 개발자가 사용하는 예외 클래스이다.
    }
    
    static void m5() throws Exception {
        throw new String(); // 컴파일 오류!
        // throw로 던질 수 있는 객체는 오직 java.lang.Throwable 타입만 가능하다.
    }
    
    
    public static void main(String[] args) {
        // 예외를 받았을 때 처리하는 문법
        try {
            m();
        } catch (RuntimeException e) {
            // 예외가 발생하면 catch 블록에서 적절한 조치를 취한다.
            // 예를 들면, 다음과 같이 예외가 발생된 이유를 간단히 출력한다.
            System.out.println(e.getMessage());
        }
        System.out.println("시스템을 종료합니다.");
    }
}
