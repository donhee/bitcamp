// 예외 처리 : RuntimeException 예외를 던질 경우
package step21.ex03;

public class Exam02_2 {
    
    // RuntimeException은 클래스 이름을 보더라도 Exception의 서브클래스이다.
    static void m() throws RuntimeException {
        throw new RuntimeException(); // OK!
    }
     
    // Exception의 서브 클래스임에도 불구하고
    // RuntimeException 클래스인 경우 메서드 선언부에 예외를 던진다고 선언하지 않아도 된다.
    // 왜? 스텔스 모드(비유) 를 지원하기 위해 만든 예외이다.
    static void m2() {
        throw new RuntimeException();
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
