package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/add")
public class BoardAddController implements Controller {
    BoardDao boardDao;
      
    public BoardAddController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
     
    public void service(ServerRequest request, ServerResponse response) {
        Board board = new Board();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(new Date(System.currentTimeMillis()));

        /* 스레드 테스트용 코드
        for (int i = 0; i < 300000000; i++) {
            //Math.random(); // 0 <= x(double) < 1
            double d = Math.asin(34.8);
        } // random()를 사용할때는 이 작업단위(atomic)가 끝날때까지 다른 스레드를 실행하지 않는다.
          // long과 double은 한 작업단위(atomic)가 아니라, 두번의 작업이 개입된다.
          // int와 random()함수가 겹쳤을때는 한 작업(atomic)으로 간주된다.
        */
        boardDao.insert(board);
        
        
        PrintWriter out = response.getWriter();
        out.println("등록 성공!");
    }

}

// ver 28 - 네트워크 버전으로 변경
// ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의