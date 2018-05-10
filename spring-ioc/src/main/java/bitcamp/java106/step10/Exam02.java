// 클래스를 이용하여 스프링 설정하기 - @Configuration 애노테이션
package bitcamp.java106.step10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {

    public static void main(String[] args) {
        // 패키지명을 지정하면
        // 해당 패키지의 모든 클래스를 찾아 @Component, @Service, @Controller, @Repository
        // 애노테이션이 붙은 클래스에 대해 객체를 자동 생성한다.
        // 또한,
        // @Configuration 애노테이션이 붙은 클래스를 찾아
        // 그 클래스에 @Bean 애노테이션이 붙은 메서드를 호출하여 그 리턴 값을 저장한다.
        // AppConfig02.java에 Car3 메서드는 @Bean이 붙지 않아 객체를 생성하지 못했다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext("bitcamp.java106.step10");
                                                       // 패키지명을 줄 수도 있다.
        
        BeanUtils.printBeanNames(iocContainer);
    }
}
