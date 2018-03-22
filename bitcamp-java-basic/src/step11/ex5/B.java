// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 상속 문법을 이용한다.
package step11.ex5;

// 상속
// => 재사용할 기존 클래스를 지정한다.
// => 새 클래스에는 추가할 기능을 덧붙인다.
// 주의!!!
// => 상속이라는 단어 때문에 많이 오해한다.
//    B 클래스가 A 클래스의 코드를 자동으로 가져오는 것이 아니다!!
// => B 클래스는 A 클래스의 링크 정보만 갖고 있다.
// => 따라서 B 클래스를 사용하려면 반드시 A 클래스가 있어야 한다.
public class B extends A{
    int v2;
    
    // static 블록은 클래스가 로딩될 때 실행한다.
    static {
        System.out.println("B클래스의 static{} 실행");
    }
}
