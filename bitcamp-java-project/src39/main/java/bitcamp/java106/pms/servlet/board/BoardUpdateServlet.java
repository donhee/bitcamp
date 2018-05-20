package bitcamp.java106.pms.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        this.boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        try {
            Board board = new Board();
            board.setNo(Integer.parseInt(request.getParameter("no")));
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            
            int count = boardDao.update(board);
            if (count == 0) {
                throw new Exception("해당 게시물이 존재하지 않습니다.");
            } 
            response.sendRedirect("list");
            
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 수정 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터를 버린다.
            rd.forward(request, response);
        }
    }
    
}
// ver 38 - redirect 적용
// ver 37 - BoardUpdateController를 서블릿으로 변경
//          결과를 HTML로 출력 
//ver 26 - BoardController에서 update() 메서드를 추출하여 클래스로 정의