// 역할 : 서버 요청 정보를 다룬다.
package bitcamp.java106.pms.server;

import java.util.HashMap;
import java.util.Map;

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
            this.paramMap.put(keyValue[0], keyValue[1]);
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