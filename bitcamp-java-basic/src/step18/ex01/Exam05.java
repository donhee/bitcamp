// 클래스 로딩과 인스턴스 생성 
package step18.ex01;

public class Exam05 {
    
    static class A {
        static int s_var = 100;
        int i_var = 200;
        
        static void s_m() {}
        void i_m() {}
    
        static {
            System.out.println("A 클래스가 로딩되었다!");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex01.Exam05$A");
        
        // 타입(클래스) 정보만 있다면 인스턴스를 생성할 수 있다.
        A obj = (A) clazz.newInstance();
        obj.i_m();
    }
}
