package egovframework.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03_2")
public class Exam03_2 {
    
    // RequestMapping의 method 속성을 사용하면 특정 요청에만 호출되도록 할 수 있다.
    // 테스트 방법 : localhost:8888/spring-mvc/exam03_2.html
    @RequestMapping(value="m1", method=RequestMethod.GET)
    @ResponseBody 
    public String m1() {
        return "Exam03_2.m1()";
    }
    // 위 RequestMapping이 get인데
    // POST 요청을 보내는 경우 다음과 같은 오류를 내보낸다.
    // HTTP Status 405 - Method Not Allowed
    // Message : Request method 'POST' not supported
    // 405(허용되지 않는 방법): 요청에 지정된 방법을 사용할 수 없다. 예를 들어 POST 방식으로 요청을 받는 서버에 GET 요청을 보내는 경우, 또는 읽기 전용 리소스에 PUT 요청을 보내는 경우에 이 코드를 제공한다
    
    @RequestMapping(value="m2", method=RequestMethod.POST)
    @ResponseBody 
    public String m2() {
        return "Exam03_2.m2()";
    }
    
}
