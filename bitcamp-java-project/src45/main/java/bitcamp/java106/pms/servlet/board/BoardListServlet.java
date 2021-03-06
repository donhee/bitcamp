package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        boardDao = iocContainer.getBean(BoardDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            List<Board> list = boardDao.selectList();
            
            request.setAttribute("list", list);
            
            // 프론트 컨트롤러에게 전달할 JSP URL을 설정한다.
            request.setAttribute("viewUrl", "/board/list.jsp");
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
}
// ver 45 - Front Controller 적용
// ver 42 - JSP 적용
// ver 37 - BoardListController를 서블릿으로 변경
// ver 31 - JDBC API가 적용된 DAO 사용
// ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 list() 메서드를 추출하여 클래스로 정의