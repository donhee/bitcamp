// 메서드 정보 추출 - 특정 메서드만 호출
package step18.ex03;

import java.lang.reflect.Method;

public class Exam03 {
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) throws Exception {
        // 클래스 로딩
        Class clazz = Exam03.class;
    
        // 파라미터가 없는 "m3" 이름을 가진 public 메서드 추출
        //Method m = clazz.getMethod("m3"); // 못찾는다. 왜냐하면 public이 아니기 때문에!!
        Method m2 = clazz.getMethod("m1"); // public이기 때문에 찾을 수 있다 . m2메소드도 찾을 수 있다.
        //System.out.println(m.getName());
        System.out.println(m2.getName());
        
        System.out.println(clazz.getMethod("toString").getName());
        System.out.println("-----------------------------");
        
        // => 지정된 클래스에 정의된 메서드를 찾는다. 상속 받은 메서드는 제외한다.
        //    public이 아니어도 된다.
        m2 = clazz.getDeclaredMethod("m3");
        System.out.println(m2.getName());
        System.out.println(clazz.getDeclaredMethod("toString")); // 실행오류!
            // 상속 받은 메서드는 못찾는다.
        
        //getMethod()는 상속받은 메서드까지 찾을 수 있지만 public만 찾는다
        //getDeclaredMethod()는 상속받은 메서드는 찾을 수 없다.
    }

}
