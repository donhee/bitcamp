package step10.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex04/exam03")
public class Exam03_test extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int age = Integer.parseInt(request.getParameter("age"));
        
        HttpSession session = request.getSession();
        session.setAttribute("age", age);
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='UTF-8'>");
        out.println("   <title>session 확인</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='exam04' method='post'>");
        out.println("전화 : <input type='text' name='tel'>");
        out.println("<button>다음</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
        
    }
}
