// 응용 - Echo Server 만들기
package step23.ex03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        ServerSocket ss = new ServerSocket(8888);
        
        while (true) {
            Socket socket = ss.accept();
        
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            
            String str = in.nextLine();
            out.println(str);
            
            in.close();
            out.close();
            socket.close();
        }
        //ss.close();
        
    
    }
}
