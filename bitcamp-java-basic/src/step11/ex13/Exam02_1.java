// 캡슐화(encapsulation) - 접근 범위 테스트
package step11.ex13;

import step11.ex13.sub.B;
import step11.ex13.sub.C;

public class Exam02_1 extends C{
    
    public static void main(String[] args) {
        A obj1 = new A();
        
        //obj1.privateVar = 100;   // 접근 불가!
        obj1.defaultVar = 100;   // OK! 
        obj1.protectedVar = 100; // OK!
        obj1.publicVar = 100;    // OK!
        
        B obj2 = new B();
        //obj2.privateVar = 100;   // 접근 불가!
        //obj2.defaultVar = 100;   // 접근 불가!
        //obj2.protectedVar = 100; // 접근 불가!
        obj2.publicVar = 100;    // 접근 불가!
    
        C obj3 = new C();
        //obj3.privateVar = 100;
        //obj3.defaultVar = 100;
        //obj3.protectedVar = 100;
            // 자식 클래스인데 접근 불가?
            // 이유?
            // 자기 자신의 인스턴스 변수가 아니다. 32번째줄 확인
        obj3.publicVar = 100;
    
        Exam02_1 obj4 = new Exam02_1();
        //obj4.privateVar = 100; // C 클래스에서만 접근가능
        //obj4.defaultVar = 100; // C 클래스와 같은 패키지가 아니다. 
        obj4.protectedVar = 100; // OK
        obj4.publicVar = 100;    // OK
    }
}
// private      : 클래스 안에서만 접근 가능
// (default)    : private + 같은 패키지 소속
// protected    : (default) + 서브 클래스에서 자신이 만든 변수일 경우
// public       : 모두 접근 가능

// 실무
// => 인스턴스 변수는 보통 private으로 접근을 제한한다.
// => 겟터와 셋터는 public으로 접근을 모두에게 공개한다.
// => 일반 메서드도 public으로 접근을 모두에게 공개한다.
// => 그 클래스 내부에서만 사용되는 메서드는 private으로 접근을 제한한다.
// => 자식 클래스의 접근을 허용할 필요가 있을 경우에만 protected로 만든다.
// => 다른 개발자가 사용할 라이브러리를 만들 때
//    그 라이브러리 내에서만 사용될 변수나 메서드인 경우 (default)로 접근을 제한한다.
//    즉 라이브러리를 만드는 개발자인 경우 (default)를 사용하는 경우가 있다.