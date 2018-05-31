# 변경 내역
- build.gradle 변경
    compile group: 'org.springframework', name: 'spring-webmvc', version: '5.0.6.RELEASE' 추가
    
- DispatcherServlet 클래스 삭제
- CharacterEncodingFilter 삭제

- web.xml 변경
  - <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class> 적용
  - <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class> 적용
  
- RequestMapping, ReqeustParam 애노테이션 삭제
  - import org.springframework.web.bind.annotation.RequestMapping; 적용
  - import org.springframework.web.bind.annotation.RequestParam; 적용
  
- XxxController 변경
  - 페이지 컨트롤러는 @Controller 애노테이션을 써서 정확히 명시해줘라. (@Component 애노테이션을 써도 되지만)
  
- Date 객체 넘어가는 것을 에러남.