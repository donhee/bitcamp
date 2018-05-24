// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/list")
public class TeamListController implements Controller {
    TeamDao teamDao;
    
    public TeamListController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            List<Team> list = teamDao.selectList();
            for (Team team : list) {
                out.printf("%s, %d, %s ~ %s\n", 
                        team.getName(), team.getMaxQty(), 
                        team.getStartDate(), team.getEndDate());
            }
        } catch (Exception e) {
            out.println("목록 가져오기 실패!");
            e.printStackTrace(out);
        }
    }

    
}