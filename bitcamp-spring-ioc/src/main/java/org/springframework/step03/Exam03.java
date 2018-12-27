package org.springframework.step03;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam03 {
    
    public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
            "org/springframework/step03/application-context-03.xml");
    
    BeanUtils.printBeanNames(iocContainer);
    }
}
