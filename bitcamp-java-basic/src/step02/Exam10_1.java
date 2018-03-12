// 상수 - 변수의 값을 고정하는 방법
package step02;

public class Exam10_1 {
    public static void main(String[] args) {
        // 변수
        // => 언제든지 값을 변경할 수 있다.
        int a;
        a = 10;
        a = 100;
        a = -300;
        a = 200;

        // 상수
        // => 값을 오직 한 번만 저장할 수 있다.
        // => 변수 앞에 final을 붙여라!
        final int b;
        b = 100;

        // 만약 final 로 선언된 변수의 값을 바꾸려 한다면?
        b = 200;
        // variable b might already have been assigned 이미 값이 할당되어있을지도 모른다.
        
        // 결론!
        // 변수와 상수를 구분하기 위해서
        // 상수인 경우 변수의 이름을 보통 모두 대문자로 작성한다.
        final float PI = 3.14159f;
        final float MILE = 0.621371f;
        
    }
}