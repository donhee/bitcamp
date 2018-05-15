// 서블릿 만들기 II - 추상 클래스를 상속 받아서 Servlet 인터페이스를 간접적으로 구현하기.
package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// => javax.servlet.Servlet 인터페이스를 직접 구현하는 것 보다
//    미리 구현한 클래스를 상속 받아서 
//    필요한 메서드만 구현하거나 재정의하는 것이 편하다!
//
@WebServlet("/step01/exam02")
public class Exam02 extends GenericServlet {
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 클라이언트가 이 서블릿의 실행을 요청할 때마다 호출된다. => 웹 브라우저에서 F5 누르면 다시 service() 호출됨!
        // => 서블릿이 해야할 일을 처리하는 코드를 여기에 둔다.
        System.out.println("Exam02.service() 호출됨!");
    }
    
    
}
