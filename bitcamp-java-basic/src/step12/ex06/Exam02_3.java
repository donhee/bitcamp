// java.util.HashMap - value 목록만 꺼내기
package step12.ex06;

import java.util.Collection;
import java.util.HashMap;

public class Exam02_3 {
    
    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("윤봉길", 16);
        
        HashMap map = new HashMap();
        
        // 값을 저장할 때 key로 사용할 객체를 저장한다.
        // 보통 key 객체로 String 객체를 많이 사용한다.
        // => 물론 어떤 객체라도 key로 사용할 수 있다.
        map.put("s01", v1);
        map.put("s02", v2);
        map.put("s03", v3);
        map.put("s04", v4);
        map.put("s05", v5);

        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        
        
        
    }
}