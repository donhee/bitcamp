package org.springframework.step06;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam02 {
    public static void main(String[] args) {
        Car c = CarFactory.create("티코");
        
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step06/application-context-02.xml");
    
        Date date = (Date) iocContainer.getBean("d1");
        System.out.println(date);
    }
}
