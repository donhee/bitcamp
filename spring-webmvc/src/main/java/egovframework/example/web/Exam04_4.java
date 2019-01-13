package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_4")
public class Exam04_4 {
    
    // 만약 클라이언트가 보낸 데이터가
    // "변수=값&변수=값&변수=값" 형태로 되어 있다면?
    @PostMapping(value="post", consumes="application/x-www-form-urlencoded")
    @ResponseBody 
    public String m1() {
        return "Exam04_4.m1() application/x-www-form-urlencoded";
    }
    
    // 만약 클라이언트가 보낸 데이터가
    // "값,값,값,값,값" 형태로 되어 있다면?
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody 
    public String m2() {
        return "Exam04_4.m2() text/csv";
    }
    
    // 만약 클라이언트가 보낸 데이터가
    // {"name:"aaa","age":20,"tel":"010-1111-2222"} 형태로 되어 있다면?
    @PostMapping(value="post", consumes="application/json")
    @ResponseBody 
    public String m3() {
        return "Exam04_3.m3() application/json";
    }
    
}
