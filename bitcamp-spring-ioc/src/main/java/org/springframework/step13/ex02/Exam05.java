package org.springframework.step13.ex02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam05 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step13/ex02/application-context-05.xml");
    
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("-------------------");
        
        Caller caller = (Caller) iocContainer.getBean(Caller.class);
        caller.test();
    }
}
