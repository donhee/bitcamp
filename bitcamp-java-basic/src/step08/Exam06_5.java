// 초기화 블록 - 스태틱 블록의 목적
package step08;

public class Exam06_5 {
    
    static class A {
        static float PI;
        static float area(int r) {
            return 2 * PI * r;
        }
        
        // 스태틱 블록은 클래스 멤버를 사용하기 전에 유효한 값으로 초기화시키는 것이 목적이다.
        static {
            PI = 3.14159f;
        }
        
        static {
            System.out.println("static{} 22222");
        }
        
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println(A.area(25));
    }
}
