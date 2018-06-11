package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public interface TeamService {
    
    List<Team> list(int pageNo, int pageSize);
    Team get(String name);
    Team getWithMembers(String name);
    int add(Team team);
    int update(Team team);
    int delete(String name);
    boolean isMember(String teamName, String memberId);
    int addMember(String teamName, String memberId);
    int deleteMember(String teamName, String memberId);
    List<Member> getMembersWithEmail(String teamName);
}
