// 팀 멤버 관리 기능을 모아 둔 클래스 
package bitcamp.java106.pms.controller;

import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
 
public class TeamMemberController {
    
    Scanner keyScan;
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberController(Scanner scanner, TeamDao teamDao, 
            MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    public void service(String menu, String option) {
        if (menu.equals("team/member/add")) {
            this.onTeamMemberAdd(option);
        } else if (menu.equals("team/member/list")) {
            this.onTeamMemberList(option);
        } else if (menu.equals("team/member/delete")) {
            this.onTeamMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onTeamMemberAdd(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return; // 메서드 호출을 끝내는것
        }
        
        System.out.println("[팀 멤버 추가]");
        System.out.print("추가할 멤버의 아이디는? ");
        String memberId = keyScan.nextLine();
        
        Member member = memberDao.get(memberId);
        if (member == null) {
            System.out.printf("%s 회원은 없습니다.", memberId);
            return;
        }
        
        //  팀에   있으면  멤버아이디가  --> 연산자역할
        if (teamMemberDao.isExist(teamName, memberId)) {
            System.out.println("이미 등록된 회원입니다.");
            return;
        }
        
        teamMemberDao.addMember(teamName, memberId);
    }

    void onTeamMemberList(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return; // 메서드 호출을 끝내는것
        }
        
        System.out.println("[팀 멤버 목록]");
        System.out.println("회원들: ");
        
        Iterator<String> iterator = teamMemberDao.getMembers(teamName);
        if (iterator != null) {
            while (iterator.hasNext()) {
                System.out.printf("%s, ", iterator.next());
            }
            System.out.println();
        }
    }
    void onTeamMemberDelete(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return; // 메서드 호출을 끝내는것
        }
        
        System.out.print("삭제할 팀원은? ");
        String memberId = keyScan.nextLine();
        
        if (!teamMemberDao.isExist(teamName, memberId)) {
            System.out.println("이 팀의 회원이 아닙니다.");
            return;
        }
        
        teamMemberDao.deleteMember(teamName, memberId);
        
        System.out.println("[팀 멤버 삭제]");
        System.out.println("삭제하였습니다.");
    }
}
// ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
// ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.