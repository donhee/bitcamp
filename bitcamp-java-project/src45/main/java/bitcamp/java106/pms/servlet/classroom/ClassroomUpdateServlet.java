package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/classroom/update")
public class ClassroomUpdateServlet extends HttpServlet {
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        classroomDao = iocContainer.getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Classroom classroom = new Classroom();
            classroom.setNo(Integer.parseInt(request.getParameter("no")));
            classroom.setTitle(request.getParameter("title"));
            classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
            classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
            classroom.setRoom(request.getParameter("room"));

            int count = classroomDao.update(classroom);
            if (count == 0) {
                throw new Exception("해당 강의가 존재하지 않습니다.");
            } 

            request.setAttribute("viewUrl", "redirect:list.do");
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
// ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용