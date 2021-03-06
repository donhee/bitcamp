package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
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
        
        Iterator<Member> iterator = memberDao.list();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            out.printf("%s, %s, %s\n", 
                member.getId(), member.getEmail(), member.getPassword());
        }
    }
   
}