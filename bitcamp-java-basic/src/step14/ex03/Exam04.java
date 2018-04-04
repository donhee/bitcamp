// 다중 인터페이스 구현
package step14.ex03;

// 여러 개의 인터페이스를 구현하지 못하는 경우가 있다.
// 메서드 명과 파라미터는 같지만, 리턴 타입이 다른 경우이다.
// C의 m3()는 리턴 타입이 void 이다.
// D2의 m3()는 리턴 타입이 int 이다.
// 이유?
// => 클래스는 이름이 같고 파라미터 형식이 다른 메서드를 여러 개 정의할 수 있지만, (오버로딩)
//    이름이 같고, 파라미터 형식도 같고 다만 리턴 타입이 다른 메서드를 여러 개 정의할 수 없다.
public class Exam04 implements C, D2 {
    // 리턴 타입만 다른 메서드를 여러 개 만들 수 없기 때문에
    // C인터페이스와 D2 인터페이스를 한 클래스에서 동시에 구현할 수 없다.
    // 따라서 다음과 같이 정의하면 컴파일 오류가 발생!!!
    public void m3() {} // C의 인터페이스 구현
    public int m3() {} // D의 인터페이스 구현
}