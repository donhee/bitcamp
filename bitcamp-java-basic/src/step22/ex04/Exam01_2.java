// 객체 읽기 - 파일의 데이터를 읽어 인스턴스 만들기
package step22.ex04;

import java.io.FileInputStream;

public class Exam01_2 {

 public static void main(String[] args) throws Exception {
     // 1) 파일의 데이터를 읽을 객체를 준비한다. 
     FileInputStream in = new FileInputStream("temp/test4.data");
     
     Member member = null;
     member = new Member();
     
     // 1) 이름 읽기
     
     byte[] buf = new byte[100];
     
     int size = in.read(); // 이름이 저장된 바이트 배열의 수
     in.read(buf, 0, size);
     member.name = new String(buf, 0, size, "UTF-8");
     
     // 2) 나이 읽기
     member.age  = in.read() << 24;
     member.age += in.read() << 16;
     member.age += in.read() << 8;
     member.age += in.read();
     
     // 3) 성별 읽기
     if (in.read() == 1) 
         member.gender = true;
     else
         member.gender = false;
     
     
     in.close();
     
     System.out.printf("%s\n", member);

 }

}


