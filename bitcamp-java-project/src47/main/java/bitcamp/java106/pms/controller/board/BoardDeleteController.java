package bitcamp.java106.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board/delete")
public class BoardDeleteController{
    BoardDao boardDao;
    
    public BoardDeleteController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        int count = boardDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list.do";
            
    }
    
}
//ver 46 - page Controller를 POJO로 변경
// ver 45 - 프론트 컨트롤러 적용
// ver 42 - JSP 적용
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 39 - forward 적용
// ver 38 - redirect 적용
// ver 37 - BoardDeleteController를 서블릿으로 변경
//          결과를 HTML로 출력
//ver 26 - BoardController에서 delete() 메서드를 추출하여 클래스로 정의