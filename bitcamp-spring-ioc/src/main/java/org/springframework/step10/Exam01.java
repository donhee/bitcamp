package org.springframework.step10;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig01.class);
    
        BeanUtils.printBeanNames(iocContainer);
    }
}
