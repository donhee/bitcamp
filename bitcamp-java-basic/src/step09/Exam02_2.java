// 인스턴스 메서드 클래스 메서드의 활용 - wrapper 클래스
package step09;

public class Exam02_2 {
    public static void main(String[] args) throws Exception{
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(200);
        Integer i3 = new Integer(300);
        
        // 1) 인스턴스 메서드 사용
        System.out.println(i2.compareTo(i1));
        System.out.println(i2.compareTo(i3));
        ///////////////////////////////////////////////
        int v1 = i2.intValue();
        System.out.println(v1);
        ///////////////////////////////////////////////
        
        // 2) 클래스 메서드(=스태틱 메서드) 사용
        int v2 = Integer.parseInt("1280");
        System.out.printf("%d\n", v2);
        ///////////////////////////////////////////////
        String s1 = Integer.toBinaryString(77); // 2진수
        String s2 = Integer.toOctalString(77); // 8진수
        String s3 = Integer.toHexString(77); // 16진수
        System.out.printf("77 = %s, %s, %s\n", s1, s2 , s3);
        ///////////////////////////////////////////////
        Integer x1 = Integer.valueOf("44");  // 문자열에 있는 수를 10진수로 간주한다
        Integer x2 = Integer.valueOf("44", 16); // 16진수 44를 10진수로 표현하면 68이다.
        Integer x3 = Integer.valueOf("100", 2); // 2진수 100을 10진수로 표현하면 4이다.
        Integer x4 = Integer.valueOf("100", 8); // 8진수 100을 10진수로 표현하면 64 이다.
        System.out.printf("%d, %d, %d, %d\n", x1, x2, x3, x4);
        ///////////////////////////////////////////////
        float f = Float.parseFloat("3.14f");
        boolean b = Boolean.parseBoolean("true");
        System.out.printf("%f, %b\n", f, b);
    }
}
