// 리터럴(literal) 설명 
package step01;

public class Exam04 {
    public static void main(String[] args) {
        // 정수
        // => 4바이트 크기의 정수
        System.out.println(10);
        System.out.println(+10);
        System.out.println(-10);

        // => 8바이트 크기의 정수
        // => 숫자 뒤에 l, L을 붙인다.
        System.out.println(10L);
        System.out.println(+10l);
        System.out.println(-10L);

        // 부동소수점
        // => 8바이트 크기
        System.out.println(3.14);
        System.out.println(31.4e-1);
        //                 31.4 * 0.1
        //
        // => 4바이트 크기
        // => 숫자 뒤에 F, f를 붙인다.
        System.out.println(10F);
        System.out.println(+10f);

        // 문자열
        System.out.println("문자열..");

        // 한 개의 문자
        System.out.println('가');
        //                 L "" 적어도 된다.

        // 논리값
        System.out.println(true);
        System.out.println(false);
    }
}

// 자바 코드로 값을 표현(literal)하는 것
// 