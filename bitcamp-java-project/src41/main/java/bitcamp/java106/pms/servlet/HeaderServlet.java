// 모든 페이지에 삽입될 공통 헤더를 출력하는 서블릿 - include
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java106.pms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 이 서블릿을 include하는 쪽에서 출력스트림의 콘텐트 타입을 설정하기 때문에
        // 이 서블릿에서는 콘텐트 타입을 설정할 필요가 없다.
        // response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        out.println("<div id='header'>");
        if (loginUser != null) {
            out.printf("    %s", loginUser.getId());
            out.printf(" <a href='%s/auth/logout'>로그아웃</a>", request.getContextPath()); // 절대경로로 줘야 바람직하다.
            //                                                 현재 웹 애플리케이션 경로; 
            ///                                                view-source:http://localhost:8888/bitcamp-java-project/board/list 확인
        } else {
            out.printf("<a href='%s/auth/login'>로그인</a>", request.getContextPath()); // 절대경로로 줘야 바람직하다.
        }
        out.println("</div>");
    
    }
}












