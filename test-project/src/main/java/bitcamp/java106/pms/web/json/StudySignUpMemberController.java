package bitcamp.java106.pms.web.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.service.StudyJoinedMemberService;

@RestController
@RequestMapping("/signup")
public class StudySignUpMemberController { 

    @Autowired ServletContext sc;
    StudyJoinedMemberService studyJoinedMemberService;
    
    public StudySignUpMemberController(StudyJoinedMemberService studyJoinedMemberService) {
        this.studyJoinedMemberService = studyJoinedMemberService;
    }
    /*
     * 회원 가입을 마친 일반회원이
     * 이미 만들어진 스터디에
     * 일반 회원으로 스터디 가입하기를 요청하는 컨트롤러
     * Table name : Study_Joined_Member
    */
    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(int studyNo, int memno) throws Exception {
        System.out.println("StudySignUpMemberController===> " + studyNo +", " + memno);
        studyJoinedMemberService.add(studyNo,memno);
    }
	
}
