// 애플리케이션 컨테이너가 갖춰야할 기능(규칙)을 정의한다.
package bitcamp.java106.pms;

public interface ApplicationContainer {
    String execute(String requestURI);

}
