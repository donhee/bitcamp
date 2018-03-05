package bitcamp.java106.pms;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        String a;
        String b;
        int i;
        String start;
        String end;

        System.out.print("팀명? ");
        a = keyScan.nextLine();
        System.out.print("설명? ");
        b = keyScan.nextLine();
        System.out.print("최대인원? ");
        i = keyScan.nextInt();
        System.out.print("시작일? ");
        start = keyScan.next();
        System.out.print("종료일? ");
        end = keyScan.next();

        System.out.println("------------------");

        System.out.println("팀명: "+ a);
        System.out.println("설명: \n" + b );
        System.out.println("최대인원: "+ i +"명");
        System.out.println("일자: "+ start + " ~ " + end);
    }
}