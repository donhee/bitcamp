// member - 목록 + PreparedStatement
package step25.ex03;

import java.util.List;

public class Exam02_list {
    public static void main(String[] args) throws Exception {
        
        MemberDao memberDao = new MemberDao();
        
        try {
            List<Member> list = memberDao.list();
            
            for (Member member : list) {
                System.out.printf("%s %s %s\n",
                        member.getId(),
                        member.getEmail(),
                        member.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("오류가 발생");
        }
        
    }
}
