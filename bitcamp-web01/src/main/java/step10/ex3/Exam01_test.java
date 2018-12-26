package step10.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/step10/ex03/exam01")
public class Exam01_test extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 세션 생성
        HttpSession session = request.getSession();
        
        // 서버에 저장하는 것이기 때문에 문자열, 숫자, 객체 모두 저장 가능하다.
        session.setAttribute("s1", "aaa");
        session.setAttribute("s2", 200); // Auto-boxing
        session.setAttribute("s3", new Date());
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("세션을 생성하고 세션에 값을 저장했습니다.");
        out.println("그리고 세션아이디를 쿠키로 보냈습니다.");
        
    }
    
}
