package org.springframework.step05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step05/application-context-01.xml");
        
        Car c1 = (Car) iocContainer.getBean("c1");
        
        System.out.println(c1);
        
    }
}
