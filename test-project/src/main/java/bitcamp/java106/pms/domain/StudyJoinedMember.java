package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudyJoinedMember implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int studyNo;
    private int memNo;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date registedDate; // 가입일
    private int grade; // 등급
    private List<StudyInfo> studyList; // 스터디 정보
    private List<Member> memberList; // 스터디에 가입된 멤버 정보

    @Override
    public String toString() {
        return "StudyJoinedMember [studyNo=" + studyNo + ", memNo=" + memNo + ", registedDate=" + registedDate
                + ", grade=" + grade + ", studyList=" + studyList + ", memberList=" + memberList + "]";
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<StudyInfo> getStudyList() {
        return studyList;
    }

    public void setStudyList(List<StudyInfo> studyList) {
        this.studyList = studyList;
    }

    public int getStudyNo() {
        return studyNo;
    }

    public void setStudyNo(int studyNo) {
        this.studyNo = studyNo;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public Date getRegistedDate() {
        return registedDate;
    }

    public void setRegistedDate(Date registedDate) {
        this.registedDate = registedDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    
}
