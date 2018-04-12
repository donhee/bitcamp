//데이터 읽기 - int 값 읽기 I
package step22.ex03;

import java.io.FileInputStream;

public class Exam01_2 {

 public static void main(String[] args) throws Exception {
     // 1) 파일의 데이터를 읽을 객체를 준비한다. 
     FileInputStream in = new FileInputStream("temp/test3.data");
     
     // Exam02_1을 실행하여 출력한 데이터를 read()로 읽는다.
     // => 파일에서 4바이트를 읽어 4바이트 변수 int에 저장하라!
     // => 읽은 바이트를 비트이동 연산자를 사용한후 값을 이동 시킨 후 변수에 저장해야 한다.
     int value = in.read(); // 실제 리턴한 값은 0x08이다.

     in.close();
     
     System.out.printf("%x\n", value);

 }

}


