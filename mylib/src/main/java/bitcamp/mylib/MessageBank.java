package bitcamp.mylib;

import java.util.HashMap;

public class MessageBank {
    public static HashMap<String,String> messageMap = new HashMap<>();

    static {
        messageMap.put("hello", "안녕하세요!");
        messageMap.put("goodbye", "안녕히 가세요!");
        messageMap.put("thanks", "감사합니다!");
        messageMap.put("hello", "안녕하세요!");
    }
    
    public static String getMessage(String name) {
        return messageMap.get(name);
    }
}
