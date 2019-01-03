package step25.ex081;

import java.util.List;

public interface BoardDao {
    int insert(Board board);
    List<Board> selectList();
}
