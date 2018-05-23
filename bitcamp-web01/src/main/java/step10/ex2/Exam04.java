// 쿠키 : 유효 사용 범위가 설정된 쿠키 값 꺼내기
package step10.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex2/exam04")
public class Exam04 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("클라이언트가 보낸 쿠키들:");

        for (Cookie cookie : cookies) {
            out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
        }
        
        // 테스트 방법:
        // http://localhost:8888/bitcamp-web01/step10/ex2/exam03
        // http://localhost:8888/bitcamp-web01/step10/ex2/exam02
        // http://localhost:8888/bitcamp-web01/step10/ex1/exam02
        
    }
}
