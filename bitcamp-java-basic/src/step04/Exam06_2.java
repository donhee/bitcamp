// 증감 연산자 : post-fix(후위) 감소 연산자
package step04;

public class Exam06_2 {
    public static void main(String[] args) {
        int i = 7;

        i--;
        // 현재 위치에 i 메모리에 들어 있는 갓을 꺼내 놓는다.
        // i 메모리의 값을 1 감소시킨다.

        i--;
        System.out.println(i);
    
        System.out.println(i--);
        // System.out.println(5);
        // i = i + 1;
        System.out.println(i);
    }
}