// 서블릿 만들기 4 - HTTP 프로토콜 다루는 기능이 추가된 HttpServlet 상속 받아 만들기
package step01;

import javax.servlet.annotation.WebServlet;


@WebServlet("/step01/exam04")
public class Exam04 extends HttpServlet {
    // 클라이언트가 실행을 요청하면,
    // HTTP 프로토콜의 명령에 따라 상속 받은 메서드중에서 doGet(), doPost(), doHead()가 호출 될 것이다.
    // 문제는,
    // 이들 메서드를 적절히 오버라이딩 하지 않았기 때문에
    // 원래 작성대로 실행될것이다.
}
