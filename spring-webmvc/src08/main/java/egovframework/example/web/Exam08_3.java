package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/exam08_3")
@SessionAttributes({"name","age","working"})
public class Exam08_3 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, Model model) {
        // 테스트:
        //      http://localhost:8888/java106-spring-webmvc/mvc/exam08_3/m1?name=hong
        
        // 세션 보관소에 데이터를 직접 저장하는 대신에 Model(또는 Map)객체에 저장한다.
        // => Model이나 Map 객체에 데이터를 저장하면, JSP에서 꺼내 쓸 수 있도록 
        //    프론트 컨트롤러가 ServletRequest 보관소로 복사한다.
        model.addAttribute("name", name);
        
        return String.format("m1(): 모델 객체를 통해서 세션에 값 넣기 - name=%s", name);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(int age, Model model) {
        // 테스트:
        //      http://localhost:8888/java106-spring-webmvc/mvc/exam08_3/m2?age=20
        
        // 세션 보관소에 데이터를 직접 저장하는 대신에 Model(또는 Map)객체에 저장한다.
        // => Model이나 Map 객체에 데이터를 저장하면, JSP에서 꺼내 쓸 수 있도록 
        //    프론트 컨트롤러가 ServletRequest 보관소로 복사한다.
        model.addAttribute("age", age);
        
        return String.format("m2(): 모델 객체를 통해서 세션에 값 넣기 - age=%d", age);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(boolean working, Model model) {
        // 테스트:
        //      http://localhost:8888/java106-spring-webmvc/mvc/exam08_3/m3?working=true
        
        // 세션 보관소에 데이터를 직접 저장하는 대신에 Model(또는 Map)객체에 저장한다.
        // => Model이나 Map 객체에 데이터를 저장하면, JSP에서 꺼내 쓸 수 있도록 
        //    프론트 컨트롤러가 ServletRequest 보관소로 복사한다.
        model.addAttribute("working", working);
        
        return String.format("m3(): 모델 객체를 통해서 세션에 값 넣기 - working=%b", working);
    }
}
