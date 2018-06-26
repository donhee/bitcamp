package bitcamp.mvc.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bitcamp.mvc.vo.Board;
import bitcamp.mvc.vo.Member;

// 물론 @Component를 사용해도 되지만,
// 데이터를 처리하는 DAO 객체인 경우 구분하기 쉽도록 @Repository라는 애노테이션을 사용한다.
@Repository
public class BoardDao {
    
    public BoardDao() {
        System.out.println("===> BoardDao()");
        Member writer = new Member();
        writer.setId("hong");
        writer.setEmail("hong@test.com");
        
        Board b1 = new Board();
        b1.setNo(1);
        b1.setTitle("제목입니다");
        b1.setUser(writer);
        b1.setCreatedDate(Date.valueOf("2018-06-22"));
        list.add(b1);
        
        Board b2 = new Board();
        b2.setNo(2);
        b2.setTitle("제목입니다2");
        b2.setUser(writer);
        b2.setCreatedDate(Date.valueOf("2018-06-22"));
        list.add(b2);
        
        Board b3 = new Board();
        b3.setNo(3);
        b3.setTitle("제목입니다3");
        b3.setUser(writer);
        b3.setCreatedDate(Date.valueOf("2018-06-22"));
        list.add(b3);
        
        Board b4 = new Board();
        b4.setNo(4);
        b4.setTitle("제목입니다4");
        b4.setUser(writer);
        b4.setCreatedDate(Date.valueOf("2018-06-22"));
        list.add(b4);
        
        Board b5 = new Board();
        b5.setNo(5);
        b5.setTitle("제목입니다5");
        b5.setUser(writer);
        b5.setCreatedDate(Date.valueOf("2018-06-22"));
        list.add(b5);
    }
    
    ArrayList<Board> list = new ArrayList<>();
    
    public void insert(Board board) {
        list.add(board);
    }

    public List<Board> selectList() {
        return list;
    }

}


