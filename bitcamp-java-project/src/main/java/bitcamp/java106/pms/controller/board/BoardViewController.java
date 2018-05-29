package bitcamp.java106.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component("/board/view")
public class BoardViewController implements PageController {
    BoardDao boardDao;
    
    public BoardViewController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        Board board = boardDao.selectOne(no);
        if (board == null) {
            throw new Exception("유효하지 않은 게시물 입니다.");
        } 
        request.setAttribute("board", board);
        
        return "/board/view.jsp";
            
    }

}
// ver 46 - page Controller를 POJO로 변경
//ver 45 - 프론트 컨트롤러 적용
// ver 42 - JSP 적용
// ver 37 - 
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 26 - BoardController에서 view() 메서드를 추출하여 클래스로 정의