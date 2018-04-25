// member - 등록 + PreparedStatement
package stetp25.ex03;

import java.util.Scanner;

public class Exam02_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        // 빈 객체 준비
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.setId(keyScan.nextLine());
        
        System.out.print("이메일? ");
        member.setEmail(keyScan.nextLine());
        
        System.out.print("패스워드? ");
        member.setPassword(keyScan.nextLine());
        
        try {
            MemberDao memberDao = new MemberDao();
            int count = memberDao.insert(member);
            System.out.printf("%d 개 입력 성공", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        keyScan.close();
    }
}
