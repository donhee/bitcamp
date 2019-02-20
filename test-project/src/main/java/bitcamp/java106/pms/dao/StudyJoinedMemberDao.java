package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.StudyJoinedMember;

public interface StudyJoinedMemberDao {
	List<StudyJoinedMember> selectList(int no);
	int delete(int no);
	int insert(Map<String,Object> params);
}
