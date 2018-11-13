// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/member/add")
public class TeamMemberAddController implements Controller {
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberAddController(TeamDao teamDao, MemberDao memberDao, 
            TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.\n", teamName);
            return;
        }
        
        String memberId = request.getParameter("memberId");
        
        Member member = memberDao.get(memberId);
        if (member == null) {
            out.printf("%s 회원은 없습니다.\n", memberId);
            return;
        }
        
        if (teamMemberDao.isExist(teamName, memberId)) {
            out.println("이미 등록된 회원입니다.");
            return;
        }
        
        teamMemberDao.addMember(teamName, memberId);
        out.println("팀에 회원 등록 성공");
    }
    
}