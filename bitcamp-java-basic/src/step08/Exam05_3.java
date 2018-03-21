// 변수 초기화 - 초기화 문장과 생성자의 실행 순서
package step08;

public class Exam05_3 {
    static class A {
        int a = 200;
        
        // 생성자는 초기화 문장을 실행한 후에 호출된다.
        A() {
            this.a = 300;
        }
    }
    public static void main(String[] args) {
        A obj1 = new A();
        // 인스턴스 변수는 생성되는 순간 0으로 자동 초기화 된다.
        System.out.println(obj1.a);
    }
}
