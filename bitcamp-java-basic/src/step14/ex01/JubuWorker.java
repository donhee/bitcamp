// 구현체(implementor) - 인터페이스에 따라 만든 클래스
package step14.ex01;

// 문법
// => class 클래스명 implements 인터페이스명, 인터페이스명, ... {...}
public class JubuWorker implements Worker{
    // 인터페이스(약속,규칙,규격,법률)를 이행하는 클래스는
    // 인터페이스에 선언된 모든 메서드를 반드시 구현해야 한다.
    
    public void execute() {
        System.out.println("주부로 일합니다.");
    }
}
