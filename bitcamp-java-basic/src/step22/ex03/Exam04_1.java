// 데이터 출력 - String 출력 
package step22.ex03;

import java.io.FileOutputStream;

public class Exam04_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        String str = "AB가각간";
        
        // str.getBytes(문자코드표)
        // => 문자열을 지정한 문자코드표에 따라 인코딩하여 바이트 배열을 만든다.
        // => str.getBytes("UTF-8") 
        //    의미: UTF-16 문자를 UTF-8 문자로 변환하여 표현하는것
        out.write(str.getBytes("UTF-8"));
        
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}