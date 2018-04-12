// BufferedInputStream와 BufferedOutputStream을 사용하여 파일 복사 및 시간 측정
package step22.ex07;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/jls8.pdf");
        BufferedInputStream in = new BufferedInputStream(fileIn); // Decorator
        
        FileOutputStream fileOut = new FileOutputStream("temp/jls8_5.pdf");
        BufferedOutputStream out = new BufferedOutputStream(fileOut); // Decorator
        
        int b;
        
        long startTime = System.currentTimeMillis(); //밀리초
        while ((b = in.read()) != -1) {
            out.write(b);
        }     // 파일을 끝까지 읽는다.
        long endTime = System.currentTimeMillis();
        
        
        System.out.println(endTime - startTime);
        
        in.close();
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}