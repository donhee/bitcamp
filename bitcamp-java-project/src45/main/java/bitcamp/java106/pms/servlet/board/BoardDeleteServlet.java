package bitcamp.java106.pms.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        this.boardDao = iocContainer.getBean(BoardDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            int count = boardDao.delete(no);
            if (count == 0) {
                throw new Exception("해당 게시물이 없습니다.");
            }
            request.setAttribute("viewUrl", "redirect:list.do");
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
// ver 45 - 프론트 컨트롤러 적용
// ver 42 - JSP 적용
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 39 - forward 적용
// ver 38 - redirect 적용
// ver 37 - BoardDeleteController를 서블릿으로 변경
//          결과를 HTML로 출력
//ver 26 - BoardController에서 delete() 메서드를 추출하여 클래스로 정의