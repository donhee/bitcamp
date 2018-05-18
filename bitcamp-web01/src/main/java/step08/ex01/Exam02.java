// 자동으로 페이지를 이동하는 방법 - Refresh(응답 헤더에 삽입)
package step08.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex1/exam02")
public class Exam02 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 응답 헤더에 Refresh를 추가한다.
        response.setHeader("Refresh", "5;url=http://www.daum.net");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>ex01.Exam02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>exam02</h1>");
        out.println("    <p>5초 후에 카카오 페이지를 다시 요청한다.<br>");
        out.println("        일종의 페이지를 자동으로 이동하는 효과가 있다.</p>");
        out.println("</body>");
        out.println("</html>");
        
        
    }
    
    
    
    
}
