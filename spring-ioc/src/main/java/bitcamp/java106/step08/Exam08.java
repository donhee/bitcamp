// 의존 객체 주입 자동화하기 - @Autowired + @Qualifier = @Resource
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam08 {

    public static void main(String[] args) {
        // @Qualifier 애노테이션을 붙이면,
        // 값은 타입의 객체가 여러 개 있다 하더라도 그 중에 지정된 이름을 갖는 객체가 주입된다.
        // 그러나 막상 실행을 하면 Engine 객체가 여러 개 있다고 실행 오류가 발생한다.
        // 이유는??
        // => @Qualifier 애노테이션을 처리할 BeanPostProcessor가 없기 때문이다.
        // 해결책??
        // => @Qualifier 애노테이션을 처리할 BeanPostProcessor를 등록하면 된다.
        //
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-08.xml");
        
        //
        System.out.println(iocContainer.getBean("c1"));
        
        System.out.println("---------------------------------");
        
        BeanUtils.printBeanNames(iocContainer);
    }

}
