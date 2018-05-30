package bitcamp.java106.pms.web;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

@Component("/team/member")
public class TeamMemberController {
    
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberController(TeamDao teamDao, MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping("/add")
    public String add(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId) throws Exception {
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        Member member = memberDao.selectOne(memberId);
        if (member == null) {
            throw new Exception(memberId + " 회원이 없습니다.");
        }
        if (teamMemberDao.isExist(teamName, memberId)) {
            throw new Exception("이미 등록된 회원입니다.");
        }
        teamMemberDao.insert(teamName, memberId);

        return "redirect:../view.do?name=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/delete")
    public String delete(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId) throws Exception {
        
        int count = teamMemberDao.delete(teamName, memberId);
        if (count == 0) {
            throw new Exception("해당 팀원이 존재하지 않습니다.");
        }

        return "redirect:../view.do?name=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/list")
    public String list(
            @RequestParam("teamName") String teamName,
            Map<String,Object> map) throws Exception {

        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        
        map.put("members", members);
        
        return "/team/member/list.jsp";
    }
    
}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - TeamMemberController를 TeamMemberServlet으로 변경
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamMemberController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
//ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.