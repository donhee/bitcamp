package org.springframework.step12.ex03;

import java.util.List;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.step12.Board;

public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step12/ex03/application-context.xml");
    
        BeanUtils.printBeanNames(iocContainer);
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        // 1) 게시물 입력
        Board board = new Board();
        board.setTitle("제목");
        board.setContent("내용");
        boardDao.insert(board);
        
        // 2) 게시물 조회
        List<Board> list = boardDao.selectList(2, 5);
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n",
                    b.getNo(),
                    b.getTitle(),
                    b.getRegisteredDate());
        }
    }        

}
