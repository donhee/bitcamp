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
@WebServlet("/step10/ex04/exam04")
public class Exam04_test extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");
        int age = (int) session.getAttribute("age");
        
        String tel = request.getParameter("tel");
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='UTF-8'>");
        out.println("   <title>session 확인</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("이름=%s\n", name);
        out.printf("나이=%d\n", age);
        out.printf("전화번호=%s\n", tel);
        out.println("</body>");
        out.println("</html>");
        
        
    }
}
