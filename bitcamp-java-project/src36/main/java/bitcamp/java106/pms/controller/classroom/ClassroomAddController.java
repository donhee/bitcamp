// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.sql.Date;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/add")
public class ClassroomAddController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomAddController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        Classroom classroom = new Classroom();

        classroom.setTitle(request.getParameter("title"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        classroom.setRoom(request.getParameter("room"));
        
        PrintWriter out = response.getWriter();
        try {
            classroomDao.insert(classroom);
            out.println("classroom 등록 성공");
        } catch (Exception e) {
            out.println("등록 실패!");
            e.printStackTrace(out);
        }
    }

}