// 할당 연산자 : +=  -=  *=  /= %= &=  |=  ^= <<=  >>=  >>>=
package step04;

public class Exam07_1 {
    public static void main(String[] args) {
        int i = 2;
        // i = i + 20;
        // += 연산자를 사용하면 위의 코드를 축약할 수 있다.
        i += 20;
        System.out.println(i);

        i = 2;
        i *= 5;
        System.out.println(i);
    }
}