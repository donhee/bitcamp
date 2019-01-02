// 객체 자동 생성 - @Component 애노테이션
package org.springframework.step09;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step09/application-context-01.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        
        System.out.println(iocContainer.getBean("car"));
    }

}





