// 의존 객체 주입 자동화하기 - 필수 의존객체와 선택 의존객체 required=true / false
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam06 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-06.xml");
        
        
        System.out.println(iocContainer.getBean("c1"));
        
    }

}
