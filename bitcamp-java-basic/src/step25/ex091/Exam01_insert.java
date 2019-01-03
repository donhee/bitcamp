package step25.ex091;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step25.ex091.Board;

public class Exam01_insert {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "step25/ex091/application-context.xml");
        
        BoardService boardService = iocContainer.getBean(BoardService.class);
        
        Board b1 = new Board();
        b1.setNo(301);
        b1.setTitle("3001");
        b1.setContent("xxxx");
        
        Board b2 = new Board();
        b2.setNo(302);
        b2.setTitle("3002");
        b2.setContent("xxxx");
        
        Board b3 = new Board();
        b3.setNo(303);
        b3.setTitle("3003");
        b3.setContent("xxxx");
        
        boardService.test2(b1, b2, b3);
        
    }

}
