package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03_3")
public class Exam03_3 {
    
    // 테스트 방법 : localhost:8888/spring-mvc/exam03_3.html
    @GetMapping(value="m1")
    @ResponseBody 
    public String m1() {
        return "Exam03_3.m1()";
    }
    
    @PostMapping(value="m2")
    @ResponseBody 
    public String m2() {
        return "Exam03_3.m2()";
    }
    
}
