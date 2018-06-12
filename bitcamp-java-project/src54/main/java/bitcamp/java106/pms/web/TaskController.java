package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.service.TaskService;
import bitcamp.java106.pms.service.TeamService;

@Controller
@RequestMapping("/team/{teamName}/task")
public class TaskController {
    
    TeamService teamService;
    TaskService taskService;

    public TaskController(TaskService taskService, TeamService teamService) {
        this.taskService = taskService;
        this.teamService = teamService;
    }
    
    @RequestMapping("add")
    public String add(
            Task task,
            @PathVariable String teamName,
            @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        Team team = teamService.get(teamName);
        if (team == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }
        
        taskService.add(task);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(
            @PathVariable String teamName, 
            @RequestParam("no") int no) throws Exception {
        
        if (taskService.delete(no) == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form(
            @PathVariable("teamName") String teamName, 
            Map<String,Object> map) throws Exception {
        
        if (teamService.get(teamName) == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamService.getMembersWithEmail(teamName);
        map.put("members", members);
        map.put("teamName", teamName);
        
        return "task/form";
    }
    
    @RequestMapping("list{page}")
    public String list(
            @PathVariable String teamName,
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) throws Exception {
        
        Team team = teamService.get(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        
        List<Task> list = taskService.list(teamName, pageNo, pageSize);
        map.put("list", list);
        map.put("teamName", teamName);
        
        return "task/list";
    }
    
    @RequestMapping("update")
    public String update(
            @PathVariable String teamName,
            @RequestParam("memberId") String memberId, 
            Task task) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        if (taskService.update(task) == 0) {
            throw new Exception("해당 작업이 없습니다.");
        }
        
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(
            @PathVariable String teamName,
            @PathVariable("no") int no, 
            Map<String,Object> map) throws Exception {
        
        Task task = taskService.get(no);
        if (taskService.get(no) == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        
        List<Member> members = teamService.getMembersWithEmail(teamName);
        
        map.put("teamName", teamName);
        map.put("members", members);
        map.put("task", task);
        
        return "task/view";
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
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - CharacterEncodingFilter 필터 적용.
//         request.setCharacterEncoding("UTF-8") 제거
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
