package bitcamp.java106.step12.ex4;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;
import bitcamp.java106.step12.Board;

public class Exam01 {

    public static void main(String[] args) {
        // 3단계 : Spring과 Mybatis 연동 : mybatis가 구현한 DAO 사용하기
        // 우리가 직접 스프링 IoC 컨테이너에서 사용할
        // SqlSessionFactory 빌더 클래스를 만들 필요가 없다.
        // mybatis에서 제공해주는 FactoryBean을 사용해보자!
        // 1) mvnrepository.com 에서 mybatis-spring 라이브러리 검색
        // 2) "build.gradle"에 의존 라이브러리 정보 추가
        // 3) "gradle eclipse" 실행
        // 4) 이클립스 프로젝트 갱신
        // 5) 이 라이브러리에서 제공하는 FactoryBean 사용!
        //
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step12/ex4/application-context.xml");
        
        BeanUtils.printBeanNames(iocContainer);
    
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        // 1) 게시물 입력
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        boardDao.insert(board);
        
        // 2) 게시물 목록 조회
        // => selectList()의 파라미터 값을 한 개만 넘겨야 하기 때문에
        //    여러 개의 값을 넣고 싶으면 Map에 담아 넘긴다.
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", 0);
        params.put("pageSize", 5);
        
        List<Board> list = boardDao.selectList(params);
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n", 
                    b.getNo(),
                    b.getTitle(),
                    b.getRegisteredDate());
        }
    }

}
