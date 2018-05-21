// 다른 서블릿의 작업을 포함하기 - include
package step08.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex3/exam01")
public class Exam01 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>include</title>");
        RequestDispatcher rd = request.getRequestDispatcher("/step08/ex3/common");
        rd.include(request, response);
        out.println("</head>");
        out.println("<body>");
        
        rd = request.getRequestDispatcher("/step08/ex3/header");
        rd.include(request, response);
        
        out.printf("<h1>%s 님 반갑습니다.</h1>\n", name);
        
        rd = request.getRequestDispatcher("/step08/ex3/footer");
        rd.include(request, response);
        
        out.println("</body>");
        out.println("</html>");
        
        
    }
    
    
    
    
}
