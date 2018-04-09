// 애노테이션 프로퍼티 타입
package step20.ex06;

// @MyAnnotation은 메서드와 타입(인터페이스와 클래스)에만 붙일 수 있다.
@MyAnnotation // OK!
public class MyClass {
    
    @MyAnnotation int i; // 컴파일 오류!
    
    @MyAnnotation public void m() {} // OK!
}
