// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/classroom/delete")
public class ClassroomDeleteServlet extends HttpServlet {
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        classroomDao = InitServlet.getApplicationContext().getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            int count = classroomDao.delete(no);
            
            if (count == 0) {
                throw new Exception("해당 강의가 없습니다.");
            } 
            response.sendRedirect("list");
            
        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta http-equiv='Refresh' content='5;url=list'>");
            out.println("<title>강의 삭제</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>삭제 실패!</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}


//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
