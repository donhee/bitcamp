package step25.ex091;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_list {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "step25/ex091/application-context.xml");
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        List<Board> list = boardDao.selectList();
        for (Board board : list) {
            System.out.printf("%d, %s, %s\n", board.getNo(), board.getTitle(), board.getRegisteredDate());
        }
        
    }

}
