package egovframework.example.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import egovframework.example.vo.Board;

@Controller
@RequestMapping("/exam05_9")
public class Exam05_9 {
    
    // 클라이언트로부터 한 통으로 된 값을 받을 때
    // @RequestBody를 사용한다.
    
    @PostMapping(value="post")
    @ResponseBody
    public String m1(String name, int age, String tel) {
        return String.format("m1(): %s %d %s", name, age, tel);
    }
    
    @PostMapping(value="post", consumes="text/plain")
    @ResponseBody
    // text/plain, text/csv, application/json 처럼
    // 통으로 값이 넘어올 때는 개별 변수로 받을 수 없다.
    // 통으로 받아야 한다. 변수명은 상관없다.
    // 단, 변수명 앞에 @RequestBody 애노테이션을 붙여야 한다.
    public String m2(@RequestBody String content) {
        return String.format("m2(): %s", content);
    }
    
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody
    public String m3(@RequestBody String content) {
        String[] values = content.split(",");
        return String.format("m3(): name=%s, age=%s, tel=%s",
                values[0], values[1], values[2]);
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping(value="post", consumes="application/json")
    @ResponseBody
    public String m4(@RequestBody String content) {
        Map<String,Object> map = new Gson().fromJson(content, Map.class);
        
        return String.format("m4(): name=%s, age=%f, tel=%s",
                map.get("name"), map.get("age"), map.get("tel"));
    }
    
    @PostMapping(value="post2", consumes="application/json")
    @ResponseBody
    public String m5(@RequestBody String content) {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Board board = gson.fromJson(content, Board.class);
        
        
        return String.format("m4(): no=%d, title=%s, content=%s, createdDate=%s",
                board.getNo(), board.getTitle(), board.getContent(), board.getCreatedDate());
    }
    
}
