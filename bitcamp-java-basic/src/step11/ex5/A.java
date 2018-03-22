package step11.ex5;

public class A {
    int v1;
    
    // static 블록은 클래스가 로딩될 때 실행한다.
    static { 
        System.out.println("A클래스의 static{} 실행");
    }
}
