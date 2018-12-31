package org.springframework.step07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step07/application-context-02.xml");
    
        System.out.println(iocContainer.getBean("c1"));
    }
}
