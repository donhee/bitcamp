// 쿠키 : 한글 데이터 꺼내기
package step10.ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex01/exam04")
public class Exam04_test extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        ServletContext sc = this.getServletContext();
        
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        for (Cookie cookie : cookies) {
            out.printf("%s=%s\n", cookie.getName(), URLDecoder.decode(cookie.getValue(), sc.getInitParameter("encoding")));
        }

    
    
    
    }
}
