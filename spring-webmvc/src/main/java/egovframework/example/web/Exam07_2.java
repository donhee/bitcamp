package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam07_2")
public class Exam07_2 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, int age) {
        return String.format("m1(): name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m2/{value}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @PathVariable String value,
            @MatrixVariable String name,
            @MatrixVariable int age,
            @MatrixVariable String tel) {
        System.out.println(value);
        System.out.println(name);
        System.out.println(age);
        System.out.println(tel);
        return String.format("m2(): %s, %s, %d, %s", 
                value, name, age, tel);
    }
    
    
}
