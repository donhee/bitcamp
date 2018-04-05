// URL(Uniform Resource Locator) - 부가 데이터 지정
package step16.ex02;

import java.net.URL;

public class Exam04 {

    public static void main(String[] args) throws Exception{
        // 웹 상에서 자원의 위치를 표현하는 방법
        URL url = new URL("http://www.bitcamp.co.kr/a/b/hello.html?name=hong&age=20&tel=1111-1111");
        
        // URL 분석
        System.out.printf("프로토콜: %s\n", url.getProtocol());
        System.out.printf("서버주소: %s\n", url.getHost());
        System.out.printf("포트번호: %d\n", url.getPort());
        System.out.printf("경로: %s\n", url.getPath());
        System.out.printf("query: %s\n", url.getQuery());
                        // 쿼리 스트링 : ? 뒤에 출력 
        
    }

}
