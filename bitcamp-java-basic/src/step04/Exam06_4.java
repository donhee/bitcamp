// 증감 연산자 : post-fix(후위) 증감 연산자 응용 II
package step04;

public class Exam06_4 {
    public static void main(String[] args) {
        int i = 2;
        int result = i++ + i++ * i++;

        // 연산자 우선순위:
        // 1) ++, --
        // 2) *, /, %
        // 3) +,-
        // 4) =
        //
        // int result = 2 + 3 * 4;
        // int i = 5;
        System.out.printf("%d, %d\n", i, result);
    }
}