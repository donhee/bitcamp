package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;

public class BoardDao {
    Board[] boards = new Board[1000];
    int boardIndex = 0;

    public void insert(Board board) {
        board.setNo(boardIndex);
        this.boards[this.boardIndex++] = board;
    }
    
    public Board[] list() {
        Board[] arr = new Board[boardIndex];
        for (int i = 0; i < boardIndex; i++ ) 
            arr[i] = boards[i];
        return arr;
    }
    // 1000개의 방중에서 실제 저장된 방만 따로 배열에 옮겨서 리턴하는 것
    
    public Board get(int i) {
        if (i < 0 || i >= boardIndex)
            return null;
        return boards[i];
    }
    
    public void update(Board board) {
        boards[board.getNo()] = board;
       //boards[i] = board;
    }
    
    public void delete(int i) {
        boards[i] = null;
    }
}
// ver 16 - Board 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.