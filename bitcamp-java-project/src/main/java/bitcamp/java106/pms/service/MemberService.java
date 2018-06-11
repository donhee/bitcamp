package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Member;

public interface MemberService {
    List<Member> list(int pageNo, int pageSize);
    Member get(String id);
    boolean isExist(String id, String password);
    int add(Member member);
    int update(Member member);
    int delete(String id);
}
