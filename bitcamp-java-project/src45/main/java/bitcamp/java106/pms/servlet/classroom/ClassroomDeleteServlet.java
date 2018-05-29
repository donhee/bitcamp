package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/classroom/delete")
public class ClassroomDeleteServlet extends HttpServlet {
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        classroomDao = iocContainer.getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            int count = classroomDao.delete(no);
            
            if (count == 0) {
                throw new Exception("해당 강의가 없습니다.");
            } 
            
            request.setAttribute("viewUrl", "redirect:list.do");
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
// ver 45 - 프론트 컨트롤러 적용

//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
