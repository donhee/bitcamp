// 클라이언트가 보낸 파라미터의 key와 value를 한꺼번에 꺼내기
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam08")
public class Exam08 extends GenericServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Map<String, String[]> paramsMap = request.getParameterMap();

        Set<String> nameSet = paramsMap.keySet();
        for (String name : nameSet) {
            out.printf("%s==", name);
            String[] values = paramsMap.get(name);
            for (String value : values) {
                out.printf("%s, ", value);
            }
            out.println();
        }
        // ex) http://localhost:8888/bitcamp-web01/step03/exam08?name=홍길동&tel=111&age=20&address=서울&name=임꺽정&tel=222&age=30
        
        
        
    }
    
}













