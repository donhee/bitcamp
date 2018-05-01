// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/view")
public class MemberViewController implements Controller {
    MemberDao memberDao;
    
    public MemberViewController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            Member member = memberDao.selectOne(request.getParameter("id"));
    
            if (member == null) {
                out.println("해당 아이디의 회원이 없습니다.");
            } else {
                out.printf("아이디: %s\n", member.getId());
                out.printf("이메일: %s\n", member.getEmail());
                out.printf("암호: -\n");
            }
            
        } catch (Exception e) {
            out.println("상세조회 실패");
            e.printStackTrace(out);
        }
    }
    
}