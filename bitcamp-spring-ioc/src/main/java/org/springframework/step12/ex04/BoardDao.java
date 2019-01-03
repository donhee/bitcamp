package org.springframework.step12.ex04;

import java.util.List;
import java.util.Map;

import org.springframework.step12.Board;

public interface BoardDao {
    int insert(Board board);
    List<Board> selectList(Map<String,Object> map);
    int delete(int no);
}
