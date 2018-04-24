// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/update")
public class MemberUpdateController implements Controller {
    MemberDao memberDao;
    
    public MemberUpdateController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
       
        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        
        try {   
            int count = memberDao.update(member);
            if (count == 0) {
                out.println("해당 아이디의 회원을 찾을 수 없습니다.");
            } else {
                out.println("변경하였습니다.");
            }
            
        } catch (Exception e) {
            out.println("회원 변경 실패!");
            e.printStackTrace(out);
        }
    }
   
}