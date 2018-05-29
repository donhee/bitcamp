# 변경 내역
- DispatcherServlet 추가
- web.xml 변경 
  <error-page>
        <exception-type>java.lang.Throwable</exception-type>
        <location>/error.jsp</location>
    </error-page>
- 모든 서블릿 클래스 변경
  - catch문
- JSP 페이지의 모든 링크에 *.do 붙이기