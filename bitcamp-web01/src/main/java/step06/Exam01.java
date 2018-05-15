// HTML 출력
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/exam01")
public class Exam01 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>/step05/exam01</title>");
        out.println("    <meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>step06.Exam01</h1>");
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
