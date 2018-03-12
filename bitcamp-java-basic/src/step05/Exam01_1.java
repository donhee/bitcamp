// 흐름 제어문 - 조건문 if
package step05;

public class Exam01_1 {
    public static void main(String[] args) {
        int age = 17;
        
        // 1) if (조건) 문장;
        if (age >= 19) System.out.println("성인이다.");

        // 
        if (age >= 19); // if 문에 빈 문장을 넣을 수 있다. 
                //   ';' 컴파일 오류가 발생하지 않는다.
            System.out.println("성인이다");
        // 이런 경우에 개발자가 오해할 수 있다.
        // if (조건) 뒤에 문자의 끝을 표시하는 세미콜론을 사용하지 않도록 조심해라!
        
    }
}