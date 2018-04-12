// 데이터 출력 - int 값 출력 II
package step22.ex03;

import java.io.FileOutputStream;

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        int money = 1_3456_7890; // => 0x080557D2
        
        // int 메모리의 모든 바이트를 출력하려면,
        // 각 바이트를 맨 끝으로 이동한 후 writer()로 출력한다.
        // 왜? writer()는 항상 변수의 "마지막 1바이트만 출력"하기 때문이다.
        out.write(money >> 24);  // 00000008|0557D2 ==> 결과값 : 08
        out.write(money >> 16);  // 00000805|57D2   ==> 결과값 : 05
        out.write(money >> 8);   // 00080557||D2    ==> 결과값 : 57
        out.write(money);        // 080557D2        ==> 결과값 : D2
        
        // 3) 출력 도구를 닫는다.
        // => 항상 입출력 도구를 사용한 후 닫아야 한다.
        // => 어떤 입출력 도구는 닫지 않으면 버퍼(임시메모리)에 남아있는 데이터가 
        //    출력되지 않고 버려진다.
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}