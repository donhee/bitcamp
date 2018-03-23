package step11.ex11;

public class C2 extends C {
    // 다음은 C의 메서드를 오버라이딩 한 게 아니다
    // C의 m1()으 private이기 때문에 오직 C 클래스 에서만 사용할 수 있다.
    // private이기 때문에 C2에서 접근할 수 없다. 접근할 수 없으니, 오버라이딩은 불가능하다!
    //
    /*
    @Override
    private void m1() {}
    */
    
    // => @Override 빼니까 m1()을 정의할 수 있는데요?
    // => 이건 오버라이딩이 아니라 C2 클래스에 새로 메서드가 추가된 것이다.
    // => 오버라이딩이라면 @Override 애노테이션을 붙였을 때 오류가 나지 말아야 한다!
    private void m1() {}
    // 결론! 접근 권한 이 없는 메서드는 오버라이딩 불가!
    /*
    @Override
    protected void m2() {}
    
    @Override
    void m3() {}
    
    @Override
    public void m4() {}
    */
    
    // 오버라이딩(메서드를 재정의) 할 때
    // 원본 보다 접근 범위를 확대할 순 있지만 좁힐 수는 없다.
    /*
    // protected 범위에서 default로 범위는 좁혔기 때문에 오버라이딩이 될 수 없다.
    @Override
    void m2() {
        
    }
    
    */
    // protected 범위보다 접근 범위를 확대했기 때문에 오버라이딩이 된다.
    @Override
    public void m2() {
        
    }
}

//
// 멤버의 접근 범위
// private   : 같은 클래스
// default   : 같은 클래스 + 같은 패키지
// protected : 같은 클래스 + 같은 패키지 + 서브 클래스
// public    : 모두
//
// 결론!!!!
// 수퍼 클래스의 메서드를 자식 클래스가 재정의할 때
// 접근 범위를 확대할 순 있지만, 좁힐 수는 없다!!