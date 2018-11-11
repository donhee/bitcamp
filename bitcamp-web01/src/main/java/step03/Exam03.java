// 클라이언트가 보낸 데이터(요청 파라미터;request parameter)를 읽기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam03")
public class Exam03 extends GenericServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // HTTP 요청과 관련된 도구는 ServletRequest에 들어있다.
        // 특히 클라이언트가 보낸 데이터를 꺼낼 때는 getParameter("key");
        String name = request.getParameter("name");
        // => 리턴 값은 String이기 때문에 다른 타입으로 바꾸려면 적절한 형변환을 수행하라!
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("이름=%s\n", name); 
        out.printf("나이=%d\n", age);
        
        // 예) http://localhost:8888/bitcamp-web01/step03/exam03?name=홍길동&age=20
    }
    
}
//
// MIME type(Multi-purpose Internet Mail Extension) type
// => 원래는 메일을 보낼 때 콘텐츠의 타입을 알려주기 위해 만들었다.
// => 그러나 지금은 메일 뿐만 아니라 다방면에서 콘텐츠의 타입을 지정하는 용도로 사용하고 있다.
// => 예) text/html, text/plain, application/excel 등등 
// 













