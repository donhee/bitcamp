package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Team[] team = new Team[100];
        int teamIndex = 0;

        while(true) {
            System.out.print("명령> ");
            String[] array = scan.nextLine().toLowerCase().split(" ");
            String input = array[0];
            String option = null;
            if (array.length == 2) {
                option = array[1];
            }

            if (input.toLowerCase().equals("quit")) {
                System.out.println("bye bye");
                break;
            } else if (input.toLowerCase().equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : memeber/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit\n");
                continue;
            } else if (input.equals("team/add")) {

                Team teams = new Team();

                System.out.print("팀명? ");
                teams.name = scan.nextLine();

                System.out.print("설명? ");
                teams.description = scan.nextLine();

                System.out.print("최대인원? ");
                teams.maxQty = Integer.parseInt(scan.nextLine());

                System.out.print("시작일? ");
                teams.startDate = scan.nextLine();

                System.out.print("종료일? ");
                teams.endDate = scan.nextLine();

                team[teamIndex] = teams;
                teamIndex++;

            } else if (input.equals("team/list")) {
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s ~ %s\n",
                        team[i].name, team[i].maxQty, team[i].startDate, team[i].endDate);
                }

            } else if (input.equals("team/view")) {
                if (option == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }
                Team teams = null;
                for(int i = 0; i < teamIndex; i++) {
                    if (option.equals(team[i].name)) {
                        teams = team[i];    
                    }
                }
                if (teams == null) {
                    System.out.println("해당 이름의 팀이 없습니다.");
                } else {
                    System.out.printf("팀명: %s\n", teams.name);
                        System.out.printf("설명: %s\n", teams.description);
                        System.out.printf("최대인원: %d\n", teams.maxQty);
                        System.out.printf("시작일: %s\n", teams.startDate);
                        System.out.printf("종료일: %s\n", teams.endDate);
                        
                }
            }
            System.out.println();
        }//while
    }
}