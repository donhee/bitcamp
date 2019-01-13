package egovframework.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.vo.Board;

// 데이터를 처리하는 DAO 객체인 경우 구분하기 쉽도록 다음 애노테이션을 사용한다.
@Repository
public class BoardDao {
    
    public BoardDao() {
        System.out.println("===> BoardDao() 호출");
    }
    
    ArrayList<Board> list = new ArrayList<>();
    
    public void insert(Board board) {
        this.list.add(board);
    }
    
    public List<Board> selectList() {
        return this.list;
    }
    
}
