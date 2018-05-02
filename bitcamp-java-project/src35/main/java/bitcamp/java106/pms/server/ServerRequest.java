// 역할 : 서버 요청 정보를 다룬다.
package bitcamp.java106.pms.server;

import java.net.URLDecoder;
import java.util.HashMap;

public class ServerRequest {
    //생성자 실행을 마치면 path엔 /board/add
    protected String path;
    protected HashMap<String,String> paramMap = new HashMap<>();
    
    public ServerRequest(String requestLine) {
        // requestLine 데이터 예시) /board/add?title=aaa&content=bbb
        String[] arr = requestLine.split("\\?");
        
        this.path = arr[0];       // /board/add      물음표앞 부분은 path에 저장
        if (arr.length > 1) {     // ?있는경우
            toParamMap(arr[1]);   //title=aaa&content=bbb
        }
    }
    
    private void toParamMap(String queryString) {
        // queryString 예) title=aaa&content=bbb
        // 데이터는 key와 value로 분리하여 맵에 저장한다.
        String[] entryArr = queryString.split("&");
        for (String entry : entryArr) {
            String[] keyValue = entry.split("=");
            try {
            this.paramMap.put(
                    keyValue[0], 
                    // keyValue[1]는 UTF-8 코드를 ASCII 문자화시킨 것이다.
                    // 즉, UTF-8 코드를 URL인코딩 한 것이다.
                    // 그러니 원래 UTF-8로 만든 후(다시 URL디코딩 하여)에
                    // 이것을 다시 UTF-16으로 만들어 자바 String 객체를 리턴하라!
                    URLDecoder.decode(keyValue[1], "UTF-8"));
            } catch (Exception e) {
                System.out.println("URL 디코딩 오류!");
            }
        }
    }
    
    public String getServerPath() {
        return this.path;
    }
    
    public String getParameter(String name) {
        return this.paramMap.get(name);
    }
    
    
}

// ver 28 - 클래스 추가