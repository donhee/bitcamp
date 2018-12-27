package org.springframework.step02;

import org.springframework.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam03 {
    
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "org/springframework/step02/application-context-03.xml");
        
        BeanUtils.PrintBeanList(iocContainer);
        
        // 빈의 아이디로 객체를 꺼내기
        Car obj1 = (Car) iocContainer.getBean("c1");
        Car obj2 = (Car) iocContainer.getBean("c1");
        if (obj1 == obj2) System.out.println("obj1 == obj2");
        
        Car obj3 = (Car) iocContainer.getBean("c2");
        Car obj4 = (Car) iocContainer.getBean("c2");
        if (obj3 == obj4) System.out.println("obj3 == obj4");
        
        // prototype 객체는 getBean()을 호출할 때마다 생성된다.
        Car obj5 = (Car) iocContainer.getBean("c3");
        Car obj6 = (Car) iocContainer.getBean("c3");
        if (obj5 != obj6) System.out.println("obj5 != obj6");
        
    }
}
