package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/classroom/add")
public class ClassroomAddServlet extends HttpServlet {
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        classroomDao = iocContainer.getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Classroom classroom = new Classroom();
            classroom.setTitle(request.getParameter("title"));
            classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
            classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
            classroom.setRoom(request.getParameter("room"));
            classroomDao.insert(classroom);
            
            response.sendRedirect("list");
            
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "강의 등록 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터를 버린다.
            rd.forward(request, response);
        }
    }

}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - 컨트롤러를 서블릿으로 변경