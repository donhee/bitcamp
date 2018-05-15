// 파일 업로드 - 멀티파트 파라미터 값 추출하기
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 테스트 방법 :
        // http://localhost:8888/bitcamp-web01/step05/exam02_test.html
        
        // 멀티파트로 전송된 POST 요청 데이터를 추출하려면 일반적인 방법으로는 할 수 없다.
        // apache.org 사이트의 라이브러리를 사용하여 처리해보자!
        // 1) 의존 라이브러리 정보 알아내기
        //    mvnrepository.com 에서 "apache fileupload" 검색
        // 2) build.gradel에 의존 라이브러리 정보 추가
        //    compile group: 'commons-fileupload', name: 'commons-fileupload', version: '1.3.3'
        // 3) "gradle eclipse" 실행하여 이클립스 설정 파일 갱신
        // 4) 이클립스 IDE에서 이클립스 
        
        
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String photo = request.getParameter("photo");
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("이름=%s\n", name);
        out.printf("나이=%s\n", age);
        out.printf("사진=%s\n", photo);
        // => 에러가 안뜬상태로 실행하기 위해 int age를 String 으로 바굼
        // 출력 결과를 보면 name, age, photo의 값이 null이다.
        // 이유?
        // - multipart/form-data 형식으로 전송된 데이터는
        //   일반적인 방식으로 값을 꺼낼 수 없다.
        // - 즉 request.getParameter()를 사용하여 값을 꺼낼 수 없다.
        // 해결책?
        // - multipart 형식을 분석하여 값을 추출해야 한다.
        // 개발자가 직접 추출하는 코드를 작성하나요?
        // - 아니다! 이미 이런 작업을 수행하는 오픈 소스 라이브러리가 있다.
        // - 그 라이브러리를 사용하라!
        // 어떤 라이브러리 입니까???
        // - 많은 라이브러리가 있지만 전세계 개발자들이 많이 사용하는 apache 라이브러리를 사용하라!
        // 
        
        
    
    }
}
// multipart/form-data 형식으로 데이터를 보낸 POST 요청
// - 보내는 데이터를 파트 별로 분리하여 보낸다.
// - 파트와 파트의 구분자는 Content-Type 헤더에 정의되어 있다.
//   서버는 이 구분자를 사용하여 파트를 식별한다.
// - 서블릿에서 멀티파트로 전송된 값을 꺼내려면 별도의 라이브러리를 사용해야 한다.
/*
POST /bitcamp-web01/step05/exam01 HTTP/1.1
Host: localhost:8888
Content-Length: 11371
Cache-Control: max-age=0
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryGwR2KmBBAoDC2ISs
User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
Referer: http://localhost:8888/bitcamp-web01/step05/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Connection: keep-alive

------WebKitFormBoundaryGwR2KmBBAoDC2ISs
Content-Disposition: form-data; name="name"

한돈희
------WebKitFormBoundaryGwR2KmBBAoDC2ISs
Content-Disposition: form-data; name="age"

20
------WebKitFormBoundaryGwR2KmBBAoDC2ISs
Content-Disposition: form-data; name="photo"; filename="test.jpg"
Content-Type: image/jpeg

����
...........(소스생략)
------WebKitFormBoundaryGwR2KmBBAoDC2ISs-- <== 이 코드를 만나면 끝
*/

