// 산술 연산자 : 연산의 결과 타입
package step04;

public class Exam01_4 {
    public static void main(String[] args) {
       int i = 5;
       int j = 2;
       float r = (float)i / (float)j;   // 
       System.out.println(r);

       // 0111 1111 1111 1111 1111 1111 1111 1111
       int x = Integer.MAX_VALUE; // 0x7FFFFFFF
       int y = Integer.MAX_VALUE; // 0x7FFFFFFF
       int r1 = x + y; // 0xfffffffe
       long r2 = x + y;

       System.out.println(r1);
       System.out.println(r2);

       float f1 = 987.6543f;
       float f2 = 1.111111f;
       float r3 = f1 + f2;
       double r4 = f1 + f2;
       System.out.println(r3);
       System.out.println(r4);
    }
}
// int 타입의 메모리끼리 연산을 수행하면 그 결과도 int 타입이 된다.
// 즉 연산 결과는 피연산자의 타입과 같다.
//
// 형변환(type casting)?
// - 변수나 리터럴을 다른 타입의 값으로 바꾸는 것이다.
// - 주의!!!
//   원래 변수의 타입을 바꾸는 것이 아니다.
//   내부적으로는 변수에 들어 있는 값을 꺼내
//   지정된 타입의 임시 메모리를 만들어 저장한다.
//
// 결론!
// 1) 자바의 최소 연산 단위는 int 이다.
//    따라서 int 보다 작은 크기의 메모리 값을 다룰 때는
//    내부적으로 int로 자동 형변환을 수행한 다음에 연산을 수행한다.
//    내부적으로 자동 형변환하는 것을 "암시적 형변환"이라 부른다.
// => byte + byte = int
// => short + short = int
// => byte + short = int 
//
// 2) 연산 결과는 항상 피연산자의 타입과 같다.
// => int + int = int
// => long + long = long
// => float + float = float
// => double + double = double
//
// 3) 다른 타입과 연산을 수행할 때는
//    내부적으로 같은 타입으로 맞춘 다음에 실행한다.
// Exam01_5.java를 보라