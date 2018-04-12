// DataInputStream으로 객체 읽기 - 파일이 데이터를 읽어 인스턴스로 만들기 
package step22.ex07;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileIn0 = new FileInputStream("temp/test7.data");
        
        // FileInputStream 객체에 String, int, boolean 값을 읽는 
        // 장신구/보조장치/플러그인(decorator)를 장착한다.
        DataInputStream in = new DataInputStream(fileIn0);
        
        Member member = null;
        
        member = new Member();
        
     // 장신구/보조장치/플러그인(decorator)을 사용하여 String, int, boolean 값을 읽는다.
        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        in.close();
        
        System.out.printf("%s\n", member);
    }
}






