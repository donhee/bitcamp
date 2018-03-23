package step11.ex11;

public class X4 extends X3 {
    @Override
    void m1() {
        System.out.println("X4의 m1()");
    }
    void test() {
        this.m1();  // X4의 m1()
        super.m1(); // X2의 m1()
        
        
        this.m2();  // X3의 m2()
        super.m2(); // X3의 m2() 
    }
}
//
//this.메서드() 호출?
//=> 현재 클래스부터 호출할 메서드를 찾는다.
//super.메서드() 호출?
//=> 부모 클래스부터 호출할 메서드를 찾는다.