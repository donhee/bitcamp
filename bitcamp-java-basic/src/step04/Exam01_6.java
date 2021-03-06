// 산술 연산자 : 명시적 형변환
package step04;

public class Exam01_6 {
    public static void main(String[] args) {
        byte b = (byte)256;
        // 0000 0000 0000 0000 0000 0001 0000 0000
        // 4바이트 중에서 앞의 3바이트가 짤리고 뒤의 1바이트가 
        // b에 저장된다.
        System.out.println(b); // 0

        byte b2 = (byte)128;
        // 0000 0000 0000 0000 0000 0000 1000 0000
        System.out.println(b2); //-128

        byte b3 = (byte)64;
        // 0000 0000 0000 0000 0000 0000 0100 0000
        System.out.println(b3); // 64;
    }
}
