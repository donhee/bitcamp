package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Score;

public class App_test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Score[] sc = new Score[5];

        int count = 0;

        for( int i = 0; i < sc.length; i++){
            count++;
            sc[i] = new Score();

            System.out.print("팀명? ");
            sc[i].name = scanner.nextLine();

            System.out.print("설명? ");
            sc[i].description = scanner.nextLine();

            System.out.print("최대인원? ");
            sc[i].maxQty = Integer.parseInt(scanner.nextLine());

            System.out.print("시작일? ");
            sc[i].startDate = scanner.nextLine();

            System.out.print("종료일? ");
            sc[i].endDate = scanner.nextLine();

            if (count == sc.length) { // if (i == teams.length - 1)
                break;
            }

            System.out.print("계속 입력하시겠습니까?(Y/n)");
            String input = scanner.nextLine();
            if( input.equals("n")){
                break;
            }else{
                continue;
            }
            // String str = keyScan.nextLine();
            // if (str.toLowerCase().equals("n")) {
            //     break;
            // } 
                
        }
        
        System.out.println("==============");

        for( int i = 0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n", 
                sc[i].name, sc[i].maxQty, sc[i].startDate, sc[i].endDate);
        }
        
    }
}