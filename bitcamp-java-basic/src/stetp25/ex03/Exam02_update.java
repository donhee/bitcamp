// member - 변경 + PreparedStatement 
package stetp25.ex03;
 
import java.util.Scanner;

public class Exam02_update {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        Member member = new Member();
        
        System.out.print("변경할 회원은? ");
        member.setId(keyScan.nextLine());
        
        System.out.print("이메일? ");
        member.setEmail(keyScan.nextLine());
        
        System.out.print("패스워드? ");
        member.setPassword(keyScan.nextLine());
        
        try {
            MemberDao memberDao = new MemberDao();
            int count = memberDao.update(member);
            System.out.printf("%d 개 변경 성공!", count);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        keyScan.close();
    }
}
