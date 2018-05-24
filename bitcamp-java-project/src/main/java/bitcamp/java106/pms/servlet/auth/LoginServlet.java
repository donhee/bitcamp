// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    
    // memberDao 객체 준비
    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        memberDao = iocContainer.getBean(MemberDao.class);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 웹브라우저가 "id"라는 쿠키를 보냈으면 입력폼을 출력할 때 사용한다.
        String id = "";
        Cookie[] cookies = request.getCookies();
                                    // an array of all the Cookies included with this request, or null if the request has no cookies
        if (cookies != null) { // 쿠키가 null이 아닐때만 반복문을 돌려야 한다. 중요! 
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue(); 
                    break;
                }
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>로그인</h1>");
        out.println("<form action='login' method='post'>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.printf("    <th>아이디</th><td><input type='text' name='id' value='%s'></td>\n", id);
        out.println("</tr>");
        out.println("<tr>");
        out.println("    <th>암호</th><td><input type='password' name='password'></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<p><input type='checkbox' name='saveId'>아이디 저장</p>");
        out.println("<button>로그인</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Cookie cookie = null;
        if (request.getParameter("saveId") != null) {
            // 입력폼에서 로그인할 때 사용한 ID를 자동으로 출력할 수 있도록
            // 웹브라우저로 보내 저장시킨다.
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7); // 1주일동안 유지
        } else { // "아이디 저장" 체크박스를 체크하지 않았다면
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0); // 웹브라우저의 "id"라는 이름으로 저장된 쿠키가 있다면 제거한다. // 유효기간 0으로 셋팅 => 쿠키 무효화시킨다.
            // 즉, 유효기간을 0으로 설정함으로써 "id"라는 이름의 쿠키를 무효화 시키는 것이다.
        }
        response.addCookie(cookie);
        
        try {
            Member member = memberDao.selectOneWithPassword(id, password);
            
            HttpSession session = request.getSession();
            
            if (member != null) { // 로그인 성공!
                // 루트가 바뀔수 있기 때문에 request.getContextPath()로 꺼낸다.
                response.sendRedirect(request.getContextPath()); // => "/bitcamp-java-project" 이다.
                session.setAttribute("loginUser", member); // 로그인 성공시 loginUser 이름으로 member객체 저장
                
            } else { // 로그인 실패!
                session.invalidate(); // 무효화 
                
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.printf("<meta http-equiv='Refresh' content='1;url=%s'>", 
                        request.getContextPath() + "/auth/login");
                out.println("<title>로그인</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>로그인 실패!</h1>");
                out.println("<p>아이디 또는 암호가 맞지 않습니다.</p>");
                out.println("</body>");
                out.println("</html>"); 
            }
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "로그인 실패!");
            rd.forward(request, response);
        }
    }

}
// 
// [웹브라우저]                                                 [웹서버]
// GET 요청: /bitcamp-java-project/auth/login  ===>
//                                            <===   응답: 로그인 폼
// POST 요청: /bitcamp-java-project/auth/login ===>
//                                            <===   응답: redirect URL
// GET 요청: /bitcamp-java-project ===>
//                                            <===   응답: index.html
// 메인화면 출력!


// ver 41 - 클래스 추가







