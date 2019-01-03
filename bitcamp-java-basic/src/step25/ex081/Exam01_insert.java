package step25.ex081;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "step25/ex081/application-context.xml");
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        Board board = new Board();
        board.setNo(300);
        board.setTitle("3000");
        board.setContent("3000");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력\n", board.getNo());
        
        
        
    
    }
}
