package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;

@Controller
@RequestMapping("/team")
public class TeamController {

    TeamDao teamDao;
    TeamMemberDao teamMemberDao; // team을 delete할때 teamMemberDao 묶여잇음
    TaskDao taskDao; // team을 delete할때 task 묶여잇음
    
    public TeamController(TeamDao teamDao, TeamMemberDao teamMemberDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    public String add(Team team) throws Exception {
        
        teamDao.insert(team);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("name") String name) throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", name);
        teamMemberDao.delete(params);

        taskDao.deleteByTeam(name);
        
        int count = teamDao.delete(name);

        if (count == 0) {
            throw new Exception("해당 팀이 없습니다.");
        }
        
        return "redirect:list";
    }
    
    @RequestMapping("list")
    public void list(Map<String,Object> map) throws Exception {
        
        List<Team> list = teamDao.selectList();
        map.put("list", list);
        
    }
    
    @RequestMapping("update")
    public String update(Team team) throws Exception {
        
        int count = teamDao.update(team);
        if (count == 0) {
            throw new Exception("<p>해당 팀이 존재하지 않습니다.</p>");
        }
        
        return "redirect:list";
    }
    
    @RequestMapping("{name}")
    public String view(@PathVariable("name") String name, Map<String,Object> map) throws Exception {

        Team team = teamDao.selectOneWithMembers(name);

        if (team == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        map.put("team", team);
        
        return "team/view";
    }
    
    // GlobalBindingInitializer 클래스에 등록했기 때문에 따로 설정할 필요가 없다.
    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(java.sql.Date.valueOf(text));
                    }
                });
    }
    */
    
}
// ver 51 - Spring WebMVC 적용
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.