package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Score;

public class App03_test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Score[] sc = new Score[5];

        for( int i = 0; i < 5; i++){
            
            sc[i] = new Score();

            System.out.print("팀명? ");
            sc[i].teamName = scanner.nextLine();

            System.out.print("설명? ");
            sc[i].description = scanner.nextLine();

            System.out.print("최대인원? ");
            sc[i].maxQty = Integer.parseInt(scanner.nextLine());

            System.out.print("시작일? ");
            sc[i].startDate = scanner.nextLine();

            System.out.print("종료일? ");
            sc[i].endDate = scanner.nextLine();
        }
        
        System.out.println("==============");

        for( int i = 0; i < 5; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n", 
                sc[i].teamName, sc[i].maxQty, sc[i].startDate, sc[i].endDate);
        }
        
    }
}