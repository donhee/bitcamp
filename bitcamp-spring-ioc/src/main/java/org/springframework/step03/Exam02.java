package org.springframework.step03;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam02 {
    
    public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
            "org/springframework/step03/application-context-02.xml");
    
    BeanUtils.printBeanNames(iocContainer);
    }
}
