// 게시판 관리 - DB Connection Pool 적용
package step25.ex04;

import java.util.Scanner;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        // 사용자로부터 제목, 내용을 입력 받는다.
        Board board = new Board(); // 빈 객체 준비
        
        System.out.print("제목? ");
        board.setTitle(keyScan.nextLine());
        
        System.out.print("내용? ");
        board.setContent(keyScan.nextLine());
        
        try {
            DataSource dataSource = new DefaultDataSource(); // 인터페이스는 객체 생성x
            BoardDao boardDao = new BoardDao(dataSource);
            int count = boardDao.insert(board);
            System.out.printf("%d 개 입력 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}

