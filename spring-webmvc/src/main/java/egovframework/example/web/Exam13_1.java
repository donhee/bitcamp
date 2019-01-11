package egovframework.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.vo.Member;

@RestController
@RequestMapping("/exam13_1")
public class Exam13_1 {
    
    @GetMapping(value="test01")
    public Object test01(Member member) {
        throw new RuntimeException("예외 발생!!");
    }
}
