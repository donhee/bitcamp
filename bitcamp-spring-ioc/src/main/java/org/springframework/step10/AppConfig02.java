package org.springframework.step10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// AppConfig02 클래스가 스프링 설정 정보를 갖고 있는 클래스임을 선포한다!
// 그러면 AnnotationConfigApplicationContext에서 
// 이 클래스를 찾아 적절한 작업을 수행할 것이다.
@Configuration
public class AppConfig02 {
    @Bean
    public Car car2() {
        Car c = new Car(null);
        c.setMaker("비트자동차");
        c.setModel("비트카");
        c.setCc(1000);
        c.setAuto(true);
        return c;
    }
    
    public Car car3() {
        Car c = new Car(null);
        c.setMaker("비트자동차2");
        c.setModel("비트카2");
        c.setCc(1100);
        c.setAuto(true);
        return c;
    }
    
    
}
