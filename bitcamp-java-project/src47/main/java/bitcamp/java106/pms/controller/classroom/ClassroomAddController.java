package bitcamp.java106.pms.controller.classroom;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/classroom/add")
public class ClassroomAddController{
    ClassroomDao classroomDao;
    
    public ClassroomAddController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Classroom classroom = new Classroom();
        classroom.setTitle(request.getParameter("title"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        classroom.setRoom(request.getParameter("room"));
        classroomDao.insert(classroom);
        
        return "redirect:list.do";
    }

}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - 컨트롤러를 서블릿으로 변경