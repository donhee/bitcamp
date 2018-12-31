// 의존 객체 주입 자동화하기 - 인스턴스 변수에 @Autowired 애노테이션 붙이기
package org.springframework.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam04 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step08/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        
    }

}





