package egovframework.example.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.vo.Member;

@Controller
@RequestMapping("/exam05_4")
public class Exam05_4 {

    // 프론트 컨트롤러가 페이지 컨트롤러를 호출할 때 기본적으로
    // 클라이언트가 보낸 문자열 데이터를 primitive type의 값으로 변환시켜 준다.
    // 그 외의 타입에 대해서는 개발자가 프로퍼티 값 변환기(property editor)를 등록해야 한다.
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1(): %s,%s,%s", title, content, createdDate);
    }
    
    // 문자열로 넘어온 값을 커스텀 프로퍼티 에디터를 통해 Member 객체로 받을 수 있다.
    // 단, 파라미터 타입 앞에 @RequestParam을 반드시 붙여야 한다.
    @GetMapping(value="m2") 
    @ResponseBody 
    public String m2(@RequestParam Member member) {
        return String.format("m2(): id=%s, email=%s, password=%s",
                member.getId(), member.getEmail(), member.getPassword());
    }
    
    // 각 페이지 컨트롤러에 프로퍼티 에디터를 등록할 수 있다.
    // 메서드의 형식 : 
    //       public void 메서드명(WebDataBinder binder) {...}
    // 그리고 요청이 들어올 때 마다 이 메서드를 먼저 실행하도록 설정해야 한다.
    //       @InitBinder 애노테이션을 붙이면 된다.
    @InitBinder
    public void ititBinder(WebDataBinder binder) {
        // 이 메서드는 요청이 들어올 때 마다 파라미터 값을 준비하기 위해
        // 파라미터의 개수 만큼 호출된다.
        System.out.println("Exam05_4().호출됨!");
    
        // java.lang.String ===> java.sql.Date로 변환시켜주는 프로퍼티 에디터 등록
        binder.registerCustomEditor(
                java.sql.Date.class, /* 요청 핸들러의 파라미터 타입 */
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        // "text" 파라미터는 클라이언트가 보낸 데이터이다.
                        // 이렇게 문자열로 보낸 데이터는 java.sql.Date 객체로 바꿔야 한다.
                        this.setValue(Date.valueOf(text));
                    }
                });
        binder.registerCustomEditor(
                egovframework.example.vo.Member.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        // 클라이언트가 csv 포맷으로 넘긴 회원 정보를
                        // Member 객체로 바꿀 수 있다.
                        // 예) hong,hong@test.com,1111
                        String[] values = text.split(",");
                        Member obj = new Member();
                        obj.setId(values[0]);
                        obj.setEmail(values[1]);
                        obj.setPassword(values[2]);
                        this.setValue(obj);
                    }
                });
    }
    
}
