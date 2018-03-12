// 증감 연산자 : pre-fix(전위) 증가 연산자
package step04;

public class Exam06_5 {
    public static void main(String[] args) {
       int i = 2;
       
       ++i;
       // i 메모리의 값을 먼저 증가시킨다.
       // 그리고 i 메모리의 값을 그 자리에 놓는다

       ++i;

       System.out.println(i); // 4

       System.out.println(++i);
       // 풀어서 쓰면
       // i = i + 1;
       // System.out.println(i);
       System.out.println(i);
    }
}