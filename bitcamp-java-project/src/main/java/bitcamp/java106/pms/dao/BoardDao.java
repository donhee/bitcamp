package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao extends AbstractDao<Board> {
    
    public int indexOf(Object key) {
        //Object obj = (Integer) key;
        //
        int no = (Integer) key; // Integer ==> int : auto-unboxing
        // ((Integer) key).intvalue();
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = collection.get(i);
            if (originBoard.getNo() == no) {
                return i;
            }
        }
        return -1;
    }
    
}
// ver 19 - java.util.LinkedList를 사용하여 목록을 다룬다.
// ver 18 - ArrayList를 이용하여 인스턴스의 주소 목록을 다룬다.
// ver 16 - Board 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.