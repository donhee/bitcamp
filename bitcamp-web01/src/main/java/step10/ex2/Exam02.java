// 쿠키 : 유효기간이 설정된 쿠키 꺼내기
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
@WebServlet("/step10/ex2/exam02")
public class Exam02 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("클라이언트가 보낸 쿠키들:");

        for (Cookie cookie : cookies) {
            out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
        }
        // 쿠키에 유효기간이 있든 없든 웹브라우저가 웹서버에게 보내는 데이터 형식은 같다.
        // 웹 브라우저가 웹서버로 쿠키를 보내는 HTTP 프로토콜?
//        GET /bitcamp-web01/step10/ex2/exam02 HTTP/1.1
//        Host: localhost:8888
//        Connection: keep-alive
//        Pragma: no-cache
//        Cache-Control: no-cache
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//        Accept-Encoding: gzip, deflate, br
//        Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//        Cookie: c3=ccc; c1=aaa; c2=bbb
    // 유효기간이 설정되어있든 안되어있든 똑같다.
    
    
    }
}
