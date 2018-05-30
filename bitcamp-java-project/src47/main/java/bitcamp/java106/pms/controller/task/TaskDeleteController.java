package bitcamp.java106.pms.controller.task;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/delete")
public class TaskDeleteController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskDeleteController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String teamName = request.getParameter("teamName");        

        int no = Integer.parseInt(request.getParameter("no"));
        int count = taskDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
            
    }
    
}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
