// GenericServlet + HTTP 프로토콜 기능 = HttpServlet 클래스
package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 비록 HttpServlet 클래스에는 추상 클래스는 없지만
// 이 클래스의 목적이 서브 클래스에서 공통 기능을 상속해주는 것이기 때문에
// 바로 사용할 수 없도록 추상 클래스로 선언한다.
public class HttpServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 파라미터로 넘어 오는 것은 실제로 HTTP 프로토콜을 다룰수 있는 객체가 넘어 온다.
        // 즉 ServletRequest 대신에 그 자식 객체인 HttpServletRequest가 넘어 온다.
        // ServletResponse 대신에 그 자식 객체인 HttpServletResponse 객체가 넘어온다.
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        this.service(httpRequest, httpResponse);
    }
    
    protected void service (
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        String command = request.getMethod();
        
        switch (command) {
        case "GET": doGet(request, response); break;
        case "POST": doPost(request, response); break;
        case "HEAD": doHead(request, response); break;
        default:
            throw new ServletException("해당명령을 처리할수 없습니다.");
        }
    }
    
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당명령을 처리할수 없습니다.");
    }
    
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당명령을 처리할수 없습니다.");
    }
    
    protected void doHead(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당명령을 처리할수 없습니다.");
    }
    

}
