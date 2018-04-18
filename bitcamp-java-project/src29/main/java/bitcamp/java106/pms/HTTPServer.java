// HTTP 프로토콜에 따라 요청을 처리할 서버
package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    int port;
    ApplicationContainer applicationContainer;
    
    public HTTPServer(int port, ApplicationContainer applicationContainer) {
        this.port = port;
        this.applicationContainer = applicationContainer;
    }
    
    public void execute() throws Exception {
        // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("서버 실행 했음!");
        
        while (true) {
            Socket socket = serverSocket.accept();
            processRequest(socket);
        }
    }
    
    private void processRequest(Socket socket) {
        PrintWriter out = null;
        Scanner in = null;
        String requestURI = null;
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());

            // HTTP 프로토콜에서 요청 정보를 읽는다.
            boolean firstLine = true;
            while (true) {
                String line = in.nextLine();
                if (line.equals("")) // 빈 문자열을 읽을때까지 계속 읽는다.
                    break;
                
                if (!firstLine) // 첫번째 줄 라인만 뽑아내는 코드
                    continue;
                
                // HTTP 요청 프로토콜에서 첫 번째 줄에 있는 요청 URI 정보를 추출한다.
                
                requestURI = line.split(" ")[1];    // GET 0000000000000 HTTP/1.1    0000000000 부분만 requestURI에 저장
                firstLine = false;
                
            }
            
            // ApplicationContainer에게 실행을 위임한다.
            String result = applicationContainer.execute(requestURI);
                            // 리턴한 문자열은 HTTP 규격에 맞춰 60번라인에 출력한다.
            // HTTP 프로토콜에 따라 응답한다.
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain;charset=UTF-8");
            out.println();   // CRLF 빈줄 보내야한다.
            out.println(result); // 결과값
            
        } catch (Exception e) {
            out.println("서버 오류!");
            e.printStackTrace(out);
            out.println();
        } finally {
            out.close();
            in.close();
            try { socket.close(); } catch (Exception e) {}
        }
    }
}
