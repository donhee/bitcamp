// 초기화 블록 - 클래스 블록 = 스태틱 블록
package step08;

public class Exam06_4 {
    
    static class A {
        static int a;
        static void m() {}
        
        // 스태틱 블록은 클래스가 로딩된 후에 자동으로 "순서대로" 실행된다.
        static {
            System.out.println("static{} 11111");
        }
        
        static {
            System.out.println("static{} 22222");
        }
        
        
    }
    public static void main(String[] args) throws Exception {
        // 클래스가 로딩되는 경우(3가지)
        // 1번째방법(클래스 변수든 클래스 메서드든) 2번째 방법이든 3번째 방법이든 간에 "한번만" 실행된다.
        // => 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다.
        
        
        // 1) 클래스 멤버(변수와 메서드)를 최초로 사용할 때
        A.a = 100;
        //System.out.println(A.a);
        System.out.println("--------1--------");
        
        //A.m();
        System.out.println("--------2--------");
        
        // 2) 해당 클래스의 인스턴스를 최초로 생성할 때
        //    => 인스턴스를 만들려면 설계도가 있어야 하고,
        //       설계도는 메모리에 로딩되어 있어야 한다.
        //       따라서 설계도가 없으면 즉시 설계도를 로딩할 것이다.
        new A();
        System.out.println("--------3--------");
        
        // 3) 자바에서 제공하는 도구를 사용하여 강제로 클래스를 로딩시키는 경우
        //    이미 클래스가 로딩되어 있다면 다시 로딩하지 않는다.
        //    자바는 중복해서 클래스를 메모리에 로딩하지 않는다. 메모리 절약!!!!!
        Class.forName("step08.Exam06_4$A");
        System.out.println("--------4--------");
    }
}
