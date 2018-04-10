// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.teammember;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;

@Component("team/member/delete")
public class TeamMemberDeleteController implements Controller {
    
    Scanner keyScan;
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberDeleteController(Scanner scanner, TeamDao teamDao, 
            MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    public void service(String menu, String option) {
        
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(option);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", option);
            return;
        }
        
        System.out.print("삭제할 팀원은? ");
        String memberId = keyScan.nextLine();
        
        if (!teamMemberDao.isExist(option, memberId)) {
            System.out.println("이 팀의 회원이 아닙니다.");
            return;
        }

        teamMemberDao.deleteMember(option, memberId);
        
        System.out.println("[팀 멤버 삭제]");
        System.out.println("삭제하였습니다.");
    }
}