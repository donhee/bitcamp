// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/list")
public class ClassroomListController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomListController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            List<Classroom> list = classroomDao.selectList();
            for (Classroom classroom : list) {
                out.printf("%d, %s, %s ~ %s, %s\n",
                    classroom.getNo(), classroom.getTitle(), 
                    classroom.getStartDate(), classroom.getEndDate(),
                    classroom.getRoom());
            }
        } catch (Exception e) {
            out.println("목록 가져오기 실패!");
            e.printStackTrace(out);
        }
    }

}