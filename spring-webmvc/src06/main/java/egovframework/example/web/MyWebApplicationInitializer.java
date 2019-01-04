package egovframework.example.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 웹 애플리케이션을 시작할 때 이 메서드를 호출한다
        // 누가 호출하는가??
        // 서블릿 컨테이너(예: Tomcat 서버)가 호출한다.
        //    ===> spring-web.jar 파일에서 
        //         /META-INF/services/javax.servlet.SerlvetContainerInitializer 파일을 찾는다.
        //    ===> 그 파일에서 구현체 정보를 알아내어 객체를 생성한 후 호출한다.
        //    ===> SpringServletContainerInitializer.onStartup() 호출
        //         ===> WebApplicationInitializer 구현체의 onStart()을 호출한다.
        //         ===> MyWebApplicationInitializer.onStartup() 호출
        System.out.println("===> MyWebApplicationInitializer.onStartup() 호출");
    
        // 이 자바 파일에서 프론트 컨트롤러를 등록할 것이다.
        // 1) 프론트 컨트롤러가 사용할 Spring IoC 컨테이너를 만든다.
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();
        
        // 2) 프론트 컨트롤러를 만든다.
        DispatcherServlet dispatcher = new DispatcherServlet(ac);
    
        // 3) 프론트 컨트롤러를 웹 애플리케이션에 등록한다.
        //    => addServlet()의 리턴 값은 서블릿 URL 패턴 등을 설정하는 도구이다.
        Dynamic registration = servletContext.addServlet("mvc", dispatcher);
        
        // 4) load-on-startup 값 설정
        registration.setLoadOnStartup(1);
        registration.addMapping("/mvc/*");
    }
    
}
