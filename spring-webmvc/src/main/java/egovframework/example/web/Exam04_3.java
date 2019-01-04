package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_3")
public class Exam04_3 {
    
 // HTTP 요청에서 "Accept" 헤더의 값에 따라 호출될 메서드를 구분하기
    // => 클라이언트가 리턴 받기를 원하는 타입이 무엇인지를 지정하는 헤더가 Accept 이다.
    @GetMapping(value="m1", produces="text/plain")
    @ResponseBody 
    public String m1() {
        return "Exam04_3.m1() text/plain";
    }
    
    @GetMapping(value="m1", produces="text/html")
    @ResponseBody 
    public String m2() {
        return "Exam04_3.m2() text/html";
    }
    
    @GetMapping(value="m1", produces="application/pdf")
    @ResponseBody 
    public String m3() {
        return "Exam04_3.m3() pdf";
    }
    
}
