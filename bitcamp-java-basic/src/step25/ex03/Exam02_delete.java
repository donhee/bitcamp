// member + 삭제 + PreparedStatement
package step25.ex03;
  
import java.util.Scanner;

public class Exam02_delete {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("삭제할 회원 아이디는? ");
        String id = keyScan.nextLine();
        
        try {
            MemberDao memberDao = new MemberDao();
            int count = memberDao.delete(id);
            System.out.printf("%d 개 삭제 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}
