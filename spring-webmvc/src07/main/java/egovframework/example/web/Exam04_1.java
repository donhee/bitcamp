package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_1")
public class Exam04_1 {
    
    // 테스트 방법 : 
    // localhost:8888/mvc/exam04_1/m1?name=aaa
    // localhost:8888/mvc/exam04_1/m1?age=20
    // localhost:8888/mvc/exam04_1/m1?name=aaa&age=20        
    @GetMapping(value="m1", params="name")
    @ResponseBody 
    public String m1() {
        return "Exam04_1.m1() name";
    }
    
    @GetMapping(value="m1", params="age")
    @ResponseBody 
    public String m2() {
        return "Exam04_1.m2() age";
    }
    
    @GetMapping(value="m1", params= {"name","age"})
    @ResponseBody 
    public String m3() {
        return "Exam04_1.m3() name,age";
    }
    
}
