package org.springframework.step01;

import org.springframework.context.annotation.Bean;

// AnnotataionConfigApplicationContext에서 사용할
// 스프링 설정 정보를 제공하는 클래스이다.
public class AppConfig {
    // IoC 컨테이너는 @Bean으로 지정된 메서드를 호출하여
    // 그 리턴 값을 보관한다.
    @Bean("c1")
    public Car getCar() {
        Car c = new Car();
        c.setModel("우라칸");
        c.setMaker("람보");
        c.setCc(6500);
        return c;
    }
}
