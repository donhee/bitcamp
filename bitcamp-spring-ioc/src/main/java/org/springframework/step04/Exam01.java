package org.springframework.step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step04/application-context-01.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        System.out.println(iocContainer.getBean("c2"));
        System.out.println(iocContainer.getBean("c3"));
        System.out.println(iocContainer.getBean("c4"));
    }
}
