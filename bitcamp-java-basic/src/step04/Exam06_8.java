// 증감 연산자 : pre-fix(전위) 증감 연산자 응용 II
package step04;

public class Exam06_8 {
    public static void main(String[] args) {
        int i = 2;
        int result = ++i + ++i * ++i;

        System.out.printf("%d\n", result);

        // 주의!
        // 1) pre-fix 연산자나 post-fix 연산자를 리터럴에 적용할 수 없다.
        //int x = ++100; //컴파일 오류!
        //x = 100++; //컴파일 오류!
        // 2) 변수에 동시에 적용할 수 없다.
        int y = 100;
        // ++y++; //컴파일 오류!
        // (++y)++; //컴파일 오류!
    }
}