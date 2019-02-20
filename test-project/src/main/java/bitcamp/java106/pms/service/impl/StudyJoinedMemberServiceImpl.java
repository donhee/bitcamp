package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.StudyInfoDao;
import bitcamp.java106.pms.dao.StudyJoinedMemberDao;
import bitcamp.java106.pms.domain.StudyJoinedMember;
import bitcamp.java106.pms.service.StudyJoinedMemberService;

@Service
public class StudyJoinedMemberServiceImpl implements StudyJoinedMemberService{
    MemberDao memberDao;
    StudyJoinedMemberDao studyJoinedMemberDao;
    StudyInfoDao studyInfoDao;
    
	public StudyJoinedMemberServiceImpl(
	        MemberDao memberDao, 
			StudyJoinedMemberDao studyJoinedMemberDao,
			StudyInfoDao studyInfoDao) {
		this.memberDao = memberDao;
		this.studyJoinedMemberDao = studyJoinedMemberDao;
		this.studyInfoDao = studyInfoDao;
	}
	
	@Override
    public int add(int studyNo, int memno) {
	    int snum = studyInfoDao.selectStudyNo(studyNo);
	    System.out.println("StudyJoinedMemberService.add===>" + snum);
	    
	    HashMap<String,Object> params = new HashMap<>();
	    params.put("studyNo", snum); // 젤 마지막 번호
	    params.put("memNo", memno); // loginstat
	    params.put("grade", 0); // 주최자 0, 일반회원 1, 탈퇴회원 2
	    
        return studyJoinedMemberDao.insert(params);
    }
	
	@Override
	public List<StudyJoinedMember> list(int no){
		return studyJoinedMemberDao.selectList(no);
	}
	
	@Override
	public int delete(int no) {
		return studyJoinedMemberDao.delete(no);
	}
	
}

