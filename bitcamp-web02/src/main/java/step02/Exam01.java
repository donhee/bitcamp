// 서블릿을 서블릿 컨테이너에 배치하기 : 애노테이션
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 서블릿 클래스에 @WebServlet 애노테이션을 붙이면 크라이언트에서 해당 이름으로 요청할 때 시블릿 컨테이너가 호출해 줄것이다.
//
// 서블릿 이름은 URL 결로로 표현해야하고,
// 다음과 같이 value 속성에 이름을 지정하면 된다.
//   @WebServlet(value="/step02/exam01")
// 물론 value 속성 값만 지정할 때는 value 속성명을 생략할 수 있다.
//   @WebServlet("/step02/exam01")
// value 대신 urlPatterns 속성에 이름으로 지정해도된다.
//
@WebServlet(urlPatterns= {"/step02/exam01", "/step02/exam01_ok"})
public class Exam01 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("step02.Exam01.service()");
        
    }
}
