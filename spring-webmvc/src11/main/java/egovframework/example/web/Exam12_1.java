package egovframework.example.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.vo.Member;

@RestController
@RequestMapping("/exam12_1")
public class Exam12_1 {
    // 예) 서블릿 요청 파라미터를 int 타입(age 프로퍼티)으로 변환하지 못해 오류가 발생하는 예
    //
    // 클라이언트로부터 요청이 들어오면 프론트 컨트롤러는 페이지 컨트롤러의 요청 핸들러를 호출한다.
    // 요청 핸들러를 호출하기 위해서는 먼저 요청 핸들러의 아규먼트 값을 준비해야 한다.
    // 아규먼트로 서블릿 요청 파라미터를 원한다면 그 값을 준비한다.
    // 서블릿 요청 파라미터 값을 특정 Value Object에 담아 주기를 원한다면
    // 그 객체를 만들고 그 객체의 프로퍼티에 담아서 요청 핸들러에게 넘긴다.
    // 이렇게 서블릿 요청 파라미터 값을 변수가 객체에 담는 것을 "data binding"이라 부른다.
    // 서블릿 요청 파라미터는 모두 문자열이기 때문에 데이터 바인딩 과정에서
    // 문자열을 객체의 프로퍼티 타입으로 바꾸는 것이 필요하다.
    // 만약 문자열을 해당 타입으로 바꾼느 중에 오류가 발생한다면
    // 프론트 컨트롤러는 요청 핸들러를 호출하지 못하고 예외가 발생시킬 것이다.
    
    @GetMapping(value="test01") 
    public Object test01(Member member) {
        return member;
    }
    
    @GetMapping(value="test02") 
    public Object test02(Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "error!";
        }
        return member;
    }
    
    // 예3) 서블릿 요청 파라미터 값을 낱개의 변수로 받을 때는 BindingResult가 소용없다. 
    @GetMapping(value="test03")
    public Object test03(String name, int age, BindingResult result) {
        if (result.hasErrors()) {
            return "Error!";
        }
        
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        return member;
    }
}
