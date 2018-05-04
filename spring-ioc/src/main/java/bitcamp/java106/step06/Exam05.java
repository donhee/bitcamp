// 배열 프로퍼티 값 설정하기
package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam05 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step06/application-context-05.xml");
        
        // 이 예제는 Exam04 예제와 같다
        // 다만, Factory 클래스의 이름을 CarFactory3 ==> CarFactoryBean으로 바꾼 것이다.
        // 이유는???
        // 보통 FactoryBean 구현체를 만들 때는 클래스 이름 뒤에 접미사로 FactoryBean을 붙여서
        // 다른 개발자가 쉽게 알아보도록 만든다.
        System.out.println(iocContainer.getBean("c1"));
    }

}
