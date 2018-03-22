package step11.ex6;

public class C extends B {
    int v3;
    
    C() {
        // 수퍼 클래스의 어떤 생성자를 호출할지 지정하지 않으면 컴파일러는
        // 다음과 같이 수퍼 클래스의 기본 생성자를 호출하라는 명령을 붙인다!!
        //super(); // 즉 개발자가 붙이지 않으면 자동으로 붙인다.
        System.out.println("C() 생성자!");
    
        // 만약 개발자가 수퍼 클래스의 생성자를 호출하는 명령을 작성할 때
        // 그 전에 다른 코드가 있다면 컴파일러는 오류를 발생시킨다.
        // super(); // 컴파일 오류!!
        // 따라서 수퍼 클래스의 생성자를 호출하는 명령은 반드시 첫 문장으로 와야 한다.
    }
}
