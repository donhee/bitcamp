// 객체 생성
package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-02.xml");
        
        BeanUtils.printBeanList(iocContainer);
        
        // 빈의 아이디로 객체를 꺼내기
        Car c1 = (Car) iocContainer.getBean("c1");
        Car c2 = (Car) iocContainer.getBean("c2");
        if (c1 != c2) System.out.println("c1 != c2");
    
        // 빈의 별명이 지정된 경우에(id="c2" name="c3")
        // 별명으로도 객체를 꺼낼 수 있다.
        Car c3 = (Car) iocContainer.getBean("c3");
        if (c2 == c3) System.out.println("c2 == c3");
        
        System.out.println("-----------------------------------");
        
        BeanUtils.printBeanAliases(iocContainer, "c1");
        BeanUtils.printBeanAliases(iocContainer, "c2");
        BeanUtils.printBeanAliases(iocContainer, "c4"); // id를 지정하지 않고 name만 지정하면 name이 id로 사용된다.
        BeanUtils.printBeanAliases(iocContainer, "c5");
        BeanUtils.printBeanAliases(iocContainer, "c6");
        BeanUtils.printBeanAliases(iocContainer, "c7");
        BeanUtils.printBeanAliases(iocContainer, "c8"); // :은 별명을 구분할 때 구분되지 않고 한개의 별명으로 간주한다.
        BeanUtils.printBeanAliases(iocContainer, "c91");
        
        
        
    }

}
