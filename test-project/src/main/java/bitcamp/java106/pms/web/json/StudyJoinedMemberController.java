package bitcamp.java106.pms.web.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.service.StudyJoinedMemberService;

@RestController
@RequestMapping("/joinedmember")
public class StudyJoinedMemberController { 

    @Autowired ServletContext sc;
    StudyJoinedMemberService studyJoinedMemberService;
    
    public StudyJoinedMemberController(StudyJoinedMemberService studyJoinedMemberService) {
        this.studyJoinedMemberService = studyJoinedMemberService;
    }
    /*
     * 회원 가입을 마친 일반회원이
     * 스터디 만들기를 한다음
     * 스터디 정보와 회원 정보를 모두 포함하여
     * 스터디 주최자(장)가 되어 insert 하는 컨트롤러  
     * Table name : Study_Joined_Member
    */
    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(int studyNo, int memno) throws Exception {
        System.out.println("StudyJoinedMemberController===> " + studyNo +", " + memno);
        studyJoinedMemberService.add(studyNo,memno);
    }
    
    @RequestMapping("delete")
	public void delete (
			@RequestParam("no") int no) throws Exception{
    	studyJoinedMemberService.delete(no);
	}
	
	@RequestMapping("{no}")
	 public Object selectList(@PathVariable("no") int no) {
       return studyJoinedMemberService.list(no);
   }
	
	
}
