// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/delete")
public class MemberDeleteController implements Controller {
    MemberDao memberDao;
    
    public MemberDeleteController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        
        try {
            int count = memberDao.delete(id);
    
            if (count == 0) {
                out.println("해당 아이디의 회원이 없습니다.");
            } else {
                out.println("회원 삭제하였습니다.");
            }
        } catch (Exception e) {
            out.println("회원 삭제 실패!");
            e.printStackTrace(out);
        }
    }
    
}