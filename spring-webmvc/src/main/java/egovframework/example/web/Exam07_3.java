package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam07_3")
public class Exam07_3 {
    
    @GetMapping(value="m1/{value}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(@PathVariable String value) {
        return String.format("m1(): value=%s", value);
    }
    
    @GetMapping(value="m2/{team:t[a-zA-Z]+}-{member:m[a-z0-9]+}-{doc:[0-9]+}", 
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @PathVariable String team,
            @PathVariable String member,
            @PathVariable int doc) {
        
        
        // 예) 클라이언트에서 URL에 다음과 같은 형식으로 데이터를 보낼 때,
        //        .../exam07_3/m2/teamA-hong-100
        return String.format("m2(): team=%s, member=%s, doc=%d", 
                team, member, doc);
    }
    
    
}
