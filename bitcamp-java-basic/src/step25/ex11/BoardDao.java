// 데이터를 처리하는 코드를 별도의 클래스로 캡슐화시킨다.
// => Data 영속성(지속성)을 관리하는 클래스를 DAO(Data Access Object)라 부른다.
// => Data 영속성(지속성)
//    - 데이터를 저장하고 유지하는 것.
//    - "데이터 퍼시스턴스(persistence)"라 부른다.
package step25.ex11;

import java.util.List;

public interface BoardDao {
    
    List<Board> selectList();
    int insert(Board board);

}
