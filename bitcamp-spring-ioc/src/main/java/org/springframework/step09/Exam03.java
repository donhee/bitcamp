// 객체 자동 생성 - 특정 패키지의 클래스에 대해 객체 생성하지 않기
package org.springframework.step09;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Exam03 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step09/application-context-03.xml");
        
        BeanUtils.printBeanNames(iocContainer);
    }

}





