// ServletRequestAttributeListener 테스트
package step09.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step09/ex2/exam01")
public class Exam01 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 테스트: http://localhost:8888/bitcamp-web01/step09/ex2/exam01?name=aaa&age=20
        
        // 파라미터로부터 받은 값을 ServletRequest에 저장해보자!
        // 1) 파라미터 값을 꺼낸다.
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String addr = request.getParameter("address");
        
        // 2) ServletRequest에 저장한다.
        request.setAttribute("이름", name);
        request.setAttribute("나이", age);
        request.setAttribute("주소", addr);
        System.out.println("---------------------------");
        
        // 3) ServletRequest에 저장된 값을 변경한다.
        request.setAttribute("이름", "우하하");
        request.setAttribute("주소", addr + "1");

        System.out.println("---------------------------");
        System.out.printf("%s, %s, %s\n", name, age, addr);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Filter적용</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Exam01 실행!</h1>\n");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    
    
    
}
