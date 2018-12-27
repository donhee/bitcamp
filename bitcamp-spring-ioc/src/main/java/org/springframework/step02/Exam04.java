package org.springframework.step02;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam04 {
    
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step02/application-context-04.xml");
        
        BeanUtils.PrintBeanList(iocContainer);
        
        BeanUtils.printBeanAliases(iocContainer, "org.springframework.Car#0");
        BeanUtils.printBeanAliases(iocContainer, "org.springframework.Car#1");
        BeanUtils.printBeanAliases(iocContainer, "org.springframework.Car#2");
        BeanUtils.printBeanAliases(iocContainer, "org.springframework.Car#3");
        System.out.println("---");
        BeanUtils.printBeanAliases(iocContainer, "org.springframework.step02.Engine#0");
        BeanUtils.printBeanAliases(iocContainer, "org.springframework.step02.Engine#1");
        
        System.out.println("---------------------------------------");
        BeanUtils.printBeanNames(iocContainer);
    }
}
