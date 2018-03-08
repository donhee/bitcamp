package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Score;

public class App02_test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Score[] sc = new Score[5];
        sc[0] = new Score();

        System.out.print("팀명? ");
        sc[0].name = scanner.nextLine();
        System.out.print("설명? ");
        sc[0].description = scanner.nextLine();
        System.out.print("최대인원? ");
        sc[0].maxQty = Integer.parseInt(scanner.nextLine());
        System.out.print("시작일? ");
        sc[0].startDate = scanner.nextLine();
        System.out.print("종료일? ");
        sc[0].endDate = scanner.nextLine();

        System.out.println("==============");

        System.out.printf("%s, %d명, %s ~ %s", 
        sc[0].name, sc[0].maxQty, sc[0].startDate, sc[0].endDate);
    }
}