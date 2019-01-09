package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06_4")
public class Exam06_4 {
    
    @GetMapping(value="m1") 
    public String m1(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        
        // InternalResourceViewResolver를 사용하면
        // view URL을 리턴할 때 다음과 같이 간결해진다.
        return "exam06_4";
    }
    
    @GetMapping(value="m2") 
    public void m2(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 30);
    }
}
