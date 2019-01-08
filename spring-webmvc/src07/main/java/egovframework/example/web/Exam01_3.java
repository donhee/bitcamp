package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam01_3")
public class Exam01_3 {
    
    @RequestMapping("m1")
    @ResponseBody 
    public String m1() {
        return "Exam01_3.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody
    public String m2() {
        return "Exam01_3.m2()";
    }
}
