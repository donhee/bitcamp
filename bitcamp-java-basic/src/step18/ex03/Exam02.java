// 메서드 정보 추출 - 현재 클래스에 선언된 모든 메서드 호출
package step18.ex03;

import java.lang.reflect.Method;

public class Exam02 {
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) {
        // 클래스 로딩
        Class clazz = Exam02.class;
    
        // => 현재 클래스에 정의된 모든 메서드 호출  getDeclaredMethods()
        Method[] list = clazz.getDeclaredMethods();
        for (Method m : list) {
            System.out.println(m.getName());
        }
    }

}