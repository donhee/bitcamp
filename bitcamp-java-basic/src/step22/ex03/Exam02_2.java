// 데이터 읽기 - int 값 읽기 II
package step22.ex03;

import java.io.FileInputStream;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        // 1) 파일의 데이터를 읽을 객체를 준비한다. 
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        
        // Exam02_1을 실행하여 출력한 데이터를 read()로 읽는다.
        // read()는 1바이트를 읽어 int 값으로 만든 후 리턴한다.
        int value = in.read() << 24; // 00000008 => 08000000
        value += (in.read() << 16);  // 00000005 => 00050000 + => 08050000
        value += (in.read() << 8);   // 00000057 => 00005700 + => 08055700
        value += in.read();          // 000000D2 => 000000D2 + => 080557D2
        
        
        in.close();
        
        System.out.printf("%x\n", value);

    }

}