// member - 조회 + PreparedStatement
package step25.ex03;
 
import java.util.Scanner;

public class Exam02_view {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("조회할 회원은? ");
        String id = keyScan.nextLine();
        
        try {
            MemberDao memberDao = new MemberDao();
            Member member = memberDao.view(id);
            if (member != null) {
                System.out.printf("아이디: %s\n", member.getId()); 
                System.out.printf("이메일: %s\n", member.getEmail());
                System.out.printf("패스워드: %s\n", member.getPassword());
            } else {
                System.out.println("해당 회원이 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        keyScan.close();
    }
}
