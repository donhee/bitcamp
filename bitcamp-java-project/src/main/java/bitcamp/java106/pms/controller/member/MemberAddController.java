// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/add")
public class MemberAddController implements Controller {
    MemberDao memberDao;
    
    public MemberAddController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        Member member = new Member();
        
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));

        PrintWriter out = response.getWriter();
        try {
            memberDao.insert(member);
            out.println("회원 등록 성공!");
        } catch (Exception e) {
            out.println("회원 등록 실패!");
            e.printStackTrace(out);
        }
    }

}
//ver 31 - JDBC API가 적용된 DAO 사용