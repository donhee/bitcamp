package step14.ex05;

public interface Computer {
    // 초창기 컴퓨터는 계산하는 기능이 중요했다.
    void compute();
    
    // 어느덧 세월이 흘러, 터치 스크린이 등장하면서
    // 컴퓨터에서 터치가 가능한 단계로 업그레이드 하게 되었다.
    // 그래서 컴퓨터라면 이제 터치도 가능해야 한다고 결론을 내렸고,
    // 규칙을 추가하게 된다.
    //void touch(); // 추가하는 순간 기존 클래스들에서 컴파일 오류가 발생한다.!!!!!!!!!!!!!!!!!!!
    
    // 문제점
    // => 규칙을 변경하면, 그 규칙에 따라 만든 모든 클래스를 변경해야 한다.
    // => 내가 만든 규칙에 따라 내가 클래스를 만들었다면 내가 변경하면 되지만,
    //    내가 만든 규칙을 다른 많은 개바자들이 가져가서 클래스를 만들어 사용하고 있다면,
    //    내가 쉽게 규칙을 변경할 상황이 아닌 것이다.
    //    내가 규칙! 즉 인터페이스의 메서드를 변경하거나 제거, 추가하는 순간
    //    이 인터페이스를 구현한 모든 클래스들에서 컴파일 오류를 발생하게 된다.
    //
    // 하지만 계속 옛날 규칙을 가져갈 순 없고,
    // 새 프로젝트에는 변경된 규칙으로 클래스를 만들고 싶다.
    // 새 규칙을 새 인터페이스로 정의할 순 있지만,
    // 그렇게 하면 기존에 진행한 모든 프로젝트들과 호환되지 않는 문제가 발생한다.
    //
    // 기존 규칙을 변경하되, 기존 구현체에는 영향을 끼치고 싶지 않을 때
    // 바로 다음 문법을 사용하라!!
    // "디폴트 메서드(default method)" - JDK8에서 추가한 문법이다.
    default void touch() {
        // 구현할 코드 있으면 작성하고 없으면 빈 채로 내버려둔다.
    }
    // 위의 touch()라는 새 규칙을 추가하더라도
    // 기존에 작성한 FirstComputer, SecondComputer, ThirdComputer 모두
    // 컴파일 오류가 발생하지 않는다.
    // 왜?
    // "구현된 메서드이기 때문이다."
    //
    // 가능한 일반 클래스의 메서드처럼 사용하지 말아라!!!
    // 새 규칙을 추가하는 의미로 default 메서드를 사용해야지
    // 일반 클래스의 메서드처럼 상속 해줄 목적으로 default 메서드를 만들어서는 안된다.


}
