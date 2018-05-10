// 프로퍼티 에디터 - String ==> java.sql.Date으로 변환기 없이 처리하는 방법
package bitcamp.java106.step07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Exam02 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step07/application-context-02.xml");
        System.out.println(iocContainer.getBean("c1"));
        // 실행 오류 발생!!
        // 이유?
        // java.lang.String 값을 java.sql.Date 객체로 변환할 수 없어서!
        // 즉, 스프링 IoC 컨테이너에 String을 Date으로 바꾸는 변환기가 설치되어(내장되어) 있지 않다.
        // 
        // 스프링 빌트인 프로퍼티 에디터(변환기)
        // => primitive 타입 변환기는 기본으로 내장하고 있다.
        // => 따라서 String을 byte, short, int, long, float, double, boolean, char로 바꿀 수 있다.
        //
        
    }

}
