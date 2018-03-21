// 초기화 블록 - 인스턴스 블록 초기화 순서
package step08;

public class Exam06_3 {
    
    static class A {
        // ---- 실행 순서(1 -> 2 -> 3) ----
        
        // 3) 생성자 실행
        A() {
            this.a = 300;
        }
        
        // 2) 인스턴스 블록 실행 
        { // -> 인스턴스 블록 
            a = 200;
        }
        // 1) 인스턴스 변수 생성 및 할당 연산자 실행(초기화 문장 실행)
        int a = 100;
    }
    public static void main(String[] args) {
        A obj1 = new A();
        System.out.println(obj1.a);
    }
}
