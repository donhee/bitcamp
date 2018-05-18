// 자동으로 페이지를 이동하는 방법 - Refresh(HTML 페이지에 삽입하는 방법)
package step08.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex2/exam05")
public class Exam05 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // +, -, *, / 연산을 못할시에는 처리x
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>계산 결과</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>exam05</h1>");
        out.println("<p>해당 연산자를 사용할 수 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        
        
    }
    
    
    
    
}
