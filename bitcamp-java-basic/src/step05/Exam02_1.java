// 흐름 제어문 - switch 사용 전
package step05;

import java.util.Scanner;

public class Exam02_1 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("[지원부서]");
        System.out.println("1. s/w개발");
        System.out.println("2. 일반관리");
        System.out.println("3. 시설경비");
        System.out.print("지원 분야의 번호를 입력하세요? ");
        int num = keyScan.nextInt();

        System.out.println("[제출하실 서류는 다음과 같습니다.]");
        if (num == 1) {
            System.out.println("정보처리자격증");
            System.out.println("졸업증명서");
            System.out.println("이력서");
        } else if (num == 2) {
            System.out.println("졸업증명서");
            System.out.println("이력서");
        } else if (num == 3) {
            System.out.println("이력서");
        } else {
            System.out.println("올바른 번호를 입력하세요!");
        }
         
    }
}