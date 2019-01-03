package org.springframework.step13.ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step13/ex01/application-context-01.xml");
    
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("-------------------");
        
        Caller caller = (Caller) iocContainer.getBean(Caller.class);
        caller.test();
        
    }
}
