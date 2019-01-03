package step25.ex091;

import java.util.List;

public interface BoardDao {
    int insert(Board board);
    List<Board> selectList();
}
