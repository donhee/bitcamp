package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09_1")
public class Exam09_1 {
    
    @GetMapping(value="aaa/m1", produces="text/plain;charset=UTF-8")
    public String m1() {
        System.out.println("Exam09_1.m1()");
        return "exam09_1";
    }
    
    @GetMapping(value="aaa/m2", produces="text/plain;charset=UTF-8")
    public String m2() {
        System.out.println("Exam09_1.m2()");
        return "exam09_1";
    }
    
    @GetMapping(value="bbb/m3", produces="text/plain;charset=UTF-8")
    public String m3() {
        System.out.println("Exam09_1.m3()");
        return "exam09_1";
    }
    
}
