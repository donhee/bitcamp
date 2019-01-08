package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Exam01_2 {
    
    @RequestMapping("/exam01_2/m1")
    @ResponseBody 
    public String m1() {
        return "Exam01_1.m1()";
    }
    
    @RequestMapping("/exam01_2/m2")
    @ResponseBody
    public String m2() {
        return "Exam01_1.m2()";
    }
}
