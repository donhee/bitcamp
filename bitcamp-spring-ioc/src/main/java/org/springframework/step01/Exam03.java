package org.springframework.step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Exam03 {

    public static void main(String[] args) {
        // 스프링 IoC Container는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = null;
        
        // ApplicationContext 구현체 종류
        // 1) XML 파일에 작성된 설정 정보를 읽어서 처리하는 IoC 컨테이너
        //    => ClassPathXmlApplicationContext(자바 classpath에서 xml파일을 찾는다)
        //    => FileSystemXmlApplicationContext(OS 파일시스템에서 xml파일을 찾는다)
        // 2) 클래스 안에 작성된 애노테이션을 읽어서 처리하는 IoC 컨테이너
        //    => AnnotaionConfigApplicationContext
        
        
        // AnnotationConfigApplicationContext 사용
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    
        // IoC 컨테이너에 보관된 객체를 꺼내기
        Car car = (Car) iocContainer.getBean("c1");
        System.out.println(car);
    
    }
}
