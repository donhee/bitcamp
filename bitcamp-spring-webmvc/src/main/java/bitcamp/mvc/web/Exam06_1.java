// 요청 핸들러의 리턴 값 - 콘텐트를 직접 리턴하기
package bitcamp.mvc.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam06_1")
public class Exam06_1 {

    // request handler에서 콘텐트를 직접 리턴할 때는
    // 메서드 선언부에 @ResponseBody를 붙여야 한다.
    @GetMapping(value="m1")
    @ResponseBody 
    public String m1(ServletRequest request, ServletResponse response) {
        // 응답 콘텐트의 타입은 기본으로 
        // Content-Type: text/html;charset=ISO-8859-1 이다.
        // 한글은 ISO-8859-1에 정의되어 있지 않기 때문에
        // 출력할 때 ? 문자로 바뀌어 출력된다.
        return "Exam06_1.m1() ==> 012ABCabc#!@가각간";
    }

    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody 
    public String m2(ServletRequest request, ServletResponse response) {
        // @ResponseBody로  콘텐트를 출력할 때 
        // Context-Type을 설정하고 싶다면,
        // @RequestMapping, @GetMapping, @PostMapping 애노테이션에서
        // produces 속성에 콘텐트 타입을 지정하라!
        // 원래 produces은 클라이언트의 HTTP 요청 헤더인 Accept 값과 일치하는 지 비교할 때 
        // 사용하는 속성이지만,
        // 이렇게 콘텐트를 직접 출력할 때에 
        // 프론트 컨트롤러는 produces에 설정된 정보를 참고하여 
        // Content-Type을 설정한다.
        //
        return "Exam06_1.m2() ==> 012ABCabc#!@가각간";
    }
    
    
    
    
    
}
