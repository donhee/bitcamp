package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Score;

public class App01_test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Score sc = new Score();

        System.out.print("팀명? ");
        sc.name = scanner.nextLine();
        System.out.print("설명? ");
        sc.description = scanner.nextLine();
        System.out.print("최대인원? ");
        sc.maxQty = Integer.parseInt(scanner.nextLine());
        System.out.print("시작일? ");
        sc.startDate = scanner.nextLine();
        System.out.print("종료일? ");
        sc.endDate = scanner.nextLine();

        System.out.println("==============");

        System.out.printf("%s, %d명, %s ~ %s", 
            sc.name, sc.maxQty, sc.startDate, sc.endDate);
    }
}