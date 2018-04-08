// 메서드 정보 추출 - 특정 메서드만 호출
package step18.ex03;

import java.lang.reflect.Method;

public class Exam04 {

    public void m1() {}
    public void m2(String s) {}
    public void m3(String s, int i) {}
    
    public static void main(String[] args) throws Exception {
        // 클래스 로딩
        Class clazz = Exam04.class;

        // 파라미터가 없는 메서드를 찾을 때는 파라미터의 타입 정보를 넘기지 않는다. 
        System.out.println(clazz.getMethod("m1").getName());
        
        // 파라미터가 있는 메서드를 찾을 때는 그 파라미터의 타입 정보를 넘거야 한다.
        // 타입 정보 = 클래스 정보 = Class 객체
        System.out.println(clazz.getMethod("m2", String.class).getName());
        System.out.println(clazz.getMethod("m2", Class.forName("java.lang.String")).getName());
    
        System.out.println("-----------------------------");
        
        // Primitive 타입도 클래스 정보가 있다.
        // int = int.class
        // byte, short, int, long, float, double, boolean, char 는 비록 클래스는 아니지만,
        // 일반 클래스처럼 타입 정보를 꺼낼 수 있도록 "class"라는 변수를 제공한다.
        Class intType = int.class;
        Class stringType = String.class;
        Method m = clazz.getMethod("m3", stringType, intType);
        System.out.println(m.getName());
    }

}
