// 게시판 관리 - DB Connection Pool 적용
package step25.ex04;

import java.util.Scanner;

public class Exam01_delete {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("삭제할 게시물 번호는? ");
        int no = Integer.parseInt(keyScan.nextLine());
        
        try {
            DataSource dataSource = new DefaultDataSource();
            BoardDao boardDao = new BoardDao(dataSource);
            int count = boardDao.delete(no);
            System.out.printf("%d 개 삭제 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}

