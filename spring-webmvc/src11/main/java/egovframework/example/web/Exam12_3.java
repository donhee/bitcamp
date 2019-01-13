package egovframework.example.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.example.vo.Member;

@RestController
@RequestMapping("/exam12_3")
@SessionAttributes({"member", "user", "admin"})
public class Exam12_3 {
    
    // 세션에 값 저장하기
    @GetMapping(value="test01") 
    public Object test01(HttpSession session) {
        Member member = new Member();
        member.setName("테스트");
        member.setEmail("test@test.com");
        member.setId("testId");
        member.setPassword("1111");
        member.setAge(26);
        
        session.setAttribute("member", member);
        
        Member user = new Member();
        user.setName("테스트2");
        user.setEmail("test2@test.com");
        user.setId("test2");
        user.setPassword("1111");
        user.setAge(30);
        
        session.setAttribute("user", user);
        
        Member guest = new Member();
        guest.setName("테스트3");
        guest.setEmail("test3@test.com");
        guest.setId("test3");
        guest.setPassword("1111");
        guest.setAge(40);
        
        session.setAttribute("guest", guest);
        
        return "test01()...ok";
    }
    
    @GetMapping(value="test02") 
    public Object test02(
            @ModelAttribute("member") Member m1,
            @ModelAttribute("user") Member m2,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test02(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        return new Member[] {m1, m2};
    }

    @GetMapping(value="test03") 
    public Object test03(
            @ModelAttribute("member") Member m,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test02(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        return m;
    }

    @GetMapping(value="test04") 
    public Object test04(
            @ModelAttribute("guest") Member m,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
        }
        return m;
    }
    
    @GetMapping("test05")
    public Object test05(
            @ModelAttribute("admin") Member member,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
        }
        return member;
    }
    
    @ExceptionHandler(HttpSessionRequiredException.class)
    public ResponseEntity<String> handle(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.OK);
    }
}
