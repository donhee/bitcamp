package org.springframework.step07;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam04 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step07/application-context-04.xml");
    
        System.out.println(iocContainer.getBean("c1"));

        System.out.println("-------------------------------");
        
        BeanUtils.printBeanNames(iocContainer);
    }
}
