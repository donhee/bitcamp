// Exception 예외 던지고 받기
package step21.ex04;

public class Exam02 {
    
    static void m1() throws Exception {
        m2();
    }
    static void m2() throws Exception {
        m3();     
    }
    static void m3() throws Exception {
        // m4()에서 발생된 예외를 상위 호출자에게 던지려면
        // m3() 또한 메서드 선언부에 해당 예외를 기술해야 한다.
        // => "m3() 안에서 Excetption 예외가 발생합니다" 라고!
        m4();
    }
    static void m4() throws Exception {
        // 이 메서드에서 발생된 예외를 main()에 전달하는 방법
        // => 상위 호출자에게 전달하려면 여기서 catch 해서는 안된다.
        // => 여기서 예외를 처리하지 않으면 메서드 선언부에 어떤 예외가 발생하는 지 선언해줘야 한다.
        throw new Exception("m4()에서 예외 발생!!");
    }
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Exception 계열의 예외를 상위 호출자에게 전달하려면,
        // 그 호출 경로에 있는 모든 메서드에 throws 문장을 선언해야 하는 번거로움이 있다.
        // 어쩔 수 없다! 무조건 선언해야 한다.
    }
}
