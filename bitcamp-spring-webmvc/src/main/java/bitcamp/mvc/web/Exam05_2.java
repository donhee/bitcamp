// 요청 핸들러의 파라미터 - 클라이언트가 보낸 데이터를 받기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_2")
public class Exam05_2 {
    // 테스트 방법 : http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_2/m1?name=aaa&age=20
    
    
    // 프론트 컨트롤러로부터 클라이언트가 보낸 값을 파라미터로 바로 받을 수 있다.
    // => 파라미터 변수에 @RequestParam 애노테이션을 붙이면 된다.
    // => 프론트 컨트롤러는 클라이어느가 보낸 문자열 데이터를 
    //    자바 기본 데이터 형(primitive type)으로 자동 변환해 준다.
    @GetMapping(value="m1")
    @ResponseBody 
    public String m1(@RequestParam("name") String name, @RequestParam("age") int age) {
        return String.format("m1(): name=%s, age=%d\n", name, age);
    }
    
    // 만약 클라이언트가 보낸 값의 이름과 파라미터의 이름이 같은 경우
    // @RequestParam에 이름을 생략할 수 있다.
    @GetMapping(value="m2")
    @ResponseBody 
    public String m2(@RequestParam String name, @RequestParam int age) {
        return String.format("m2(): name=%s, age=%d\n", name, age);
    }
    
    // 만약 클라이언트가 보낸 값의 이름과 파라미터의 이름이 같은 경우
    // @RequestParam 애노테이션을 생략해도 된다. => 실무에서는 이렇게 사용
    // => 이 애노테이션을 붙이지 않으면 파라미터의 값이 선택 사항으로 다룬다.
    // => 즉 파라미터 값이 넘어 오지 않으면 null 값을 갖는다.
    // => 파라미터의 타입이 문자열이 아닌 경우 형변환 할 때 오류가 발생한다.
    // => age값 생략 불가! name은 생략 가능!
    // => 테스트 방법: http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_2/m3?age=20
    @GetMapping(value="m3")
    @ResponseBody 
    public String m3(String name, int age) {
        return String.format("m3(): name=%s, age=%d\n", name, age);
    }
    
    // @RequestParam 에서 필수/선택 여부를 지정할 수 있다.
    // => required 속성의 값을 false로 지정한다. (생략하면 true 이다.) - 기본은 true
    @GetMapping(value="m4")
    @ResponseBody 
    public String m4(@RequestParam(required=false) String name, @RequestParam(required=false) int age) {
        return String.format("m4(): name=%s, age=%d\n", name, age);
    }
    
    // 클라이언트가 값을 보내지 않으면 기본 값을 넣도록 지정할 수 있다.
    @GetMapping(value="m5")
    @ResponseBody 
    public String m5(
            String name,
            @RequestParam(required=false,defaultValue="20") int age) {
        return String.format("m4(): name=%s, age=%d\n", name, age);
    }
    
}
