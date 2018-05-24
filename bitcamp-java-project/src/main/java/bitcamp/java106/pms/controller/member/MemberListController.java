package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/list")
public class MemberListController implements Controller {
    MemberDao memberDao;
    
    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            List<Member> list = memberDao.selectList();
            for (Member member : list) {
                out.printf("%s, %s, -\n", 
                    member.getId(), member.getEmail());
            }
        } catch (Exception e) {
            out.println("목록 가져오기 실패");
            e.printStackTrace(out);
        }
    }
   
}