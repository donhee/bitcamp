// mybatis + spring IoC - 트랜잭션 정책 테스트
package step25.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("step25/ex11/application-context.xml");
        
        // 트랙잭션 적용 하려면?
        // 1) @Transactional 애노테이션을 처리할 객체를 등록한다.
        //    => application-context.xml 파일에 객체 추가
        // 2) 트랜잭션을 적용할 대상 메서드(test1())에 애노테이션을 붙인다.
        //    => BoardService의 메서드에 @Transactional 애노테이션을 붙인다.
        // 
        BoardService boardService = iocContainer.getBean(BoardService.class);

        Board b1 = new Board().setNo(191).setTitle("1111").setContent("x");
        Board b2 = new Board().setNo(192).setTitle("2222").setContent("xx");
        Board b3 = new Board().setNo(193).setTitle("3333").setContent("xxx");
        Board b4 = new Board().setNo(191).setTitle("4444").setContent("xxxx");
        Board b5 = new Board().setNo(195).setTitle("5555").setContent("xxxxx");
        
        boardService.test1(b1, b2, b3, b4, b5);

    }
}

