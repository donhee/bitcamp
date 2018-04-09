// 클래스 정보 추출 - 패키지 정보 알아내기
package step18.ex02;

public class Exam06 {
    
    static interface A {}
    static interface B {} 
    static interface C {} 
    
    static class D implements A, B, C {}

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex02.Exam05$D");
        
        // 해당 클래스의 패키지 정보를 가져온다.
        // getPackage()
        Package p = clazz.getPackage();
            System.out.println(p.getName());
    }

}