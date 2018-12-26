package step08.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/step08/ex02/exam02")
public class Exam02_test extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        if (!op.equals("-")) {
            RequestDispatcher rd = request.getRequestDispatcher("/step08/ex02/exam05");
            rd.forward(request, response);
            return;
        }
    
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>계산 결과</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>exam02</h1>");
        out.printf("<p>%d - %d = %d</p>\n", a, b, (a - b));
        out.println("</body>");
        out.println("</html>");
        
    }
}
