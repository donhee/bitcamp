// HTTP 클라이언트 만들기
package step23.ex07;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// HTTP 요청 프로토콜
// -------------------------------
// GET [자원주소] HTTP/1.1 (CRLF)
// Host: [서버주소] (CRLF)
// (CRLF)
// ------------------------------- 웹서버와 연결하는 방법

// 프로토콜(protocol)?
// => 클라이언트와 서버 간의 통신 규칙.
// => 데이터를 주고 받는 규칙.
public class HttpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.itworld.co.kr", 80);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // HTTP 요청 프로토콜에 따라 서버에 데이터를 전송한다.
        out.println("GET /news/108939 HTTP/1.1");
        out.println("Host: www.itworld.co.kr");
        out.println();
        
        // HTTP 요청 프로토콜에 따라 서버가 보낸 데이터를 수신한다.
        while (true) {
            try {
                System.out.println(in.nextLine());
            } catch (Exception e) {
                break;
            }
        }
        out.close();
        in.close();
        socket.close();
    }
}
