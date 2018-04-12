// 데이터 출력 - int 값 출력 
package step22.ex03;

import java.io.FileOutputStream;

public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        int money = 1_3456_7890; // => 0x80557D2
        out.write(money);  // 항상 출력할 때는 맨 끝 1바이트만 출력한다.
        
        // 3) 출력 도구를 닫는다.
        // => 항상 입출력 도구를 사용한 후 닫아야 한다.
        // => 어떤 입출력 도구는 닫지 않으면 버퍼(임시메모리)에 남아있는 데이터가 
        //    출력되지 않고 버려진다.
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}