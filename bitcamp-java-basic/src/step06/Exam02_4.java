// 메서드 : 개념 및 기본 문법 IIII
package step06;

public class Exam02_4 {
    // 1) 메서드4 : 리턴값(o), 파라미터(o)
    static String hello(String name, int age) {
        String retVal = String.format("%d살 %s님을 환영합니다.", age, name);
        return retVal;
    }

    public static void main(String[] args) {
        // hello() 메소드를 실행하고, 그 리턴 값을 변수에 담는다.
        String r = hello("홍길동", 20);
        System.out.println(r);
    
        // 리턴 값을 안 받아도 된다.
        hello("임꺽정", 40); // 리턴 값은 버려진다. (
        // L (컴파일 오류가 아니다!)
    }
}