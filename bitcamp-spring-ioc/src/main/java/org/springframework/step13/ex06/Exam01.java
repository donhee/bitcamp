package org.springframework.step13.ex06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext iocContainer = new AnnotationConfigApplicationContext(
                AppConfig.class);
    
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("-------------------");
        
        try {
            Caller caller = (Caller) iocContainer.getBean(Caller.class);
            caller.test();
        } catch (Exception e) {
            System.out.println("오류발생");
        }
    }
}
