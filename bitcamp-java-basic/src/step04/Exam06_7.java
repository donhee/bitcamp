// 증감 연산자 : pre-fix(전위) 증감 연산자 응용 I
package step04;

public class Exam06_7 {
    public static void main(String[] args) {
       int i = 2;
       i = --i;
       // i = i - 1; 수행한다.         // 1
       // i = 1;  => i에 또 1을 넣는다. // 1
       System.out.println(i);
    }
}