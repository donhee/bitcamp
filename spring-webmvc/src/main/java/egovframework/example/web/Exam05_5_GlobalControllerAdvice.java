package egovframework.example.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import egovframework.example.vo.Member;

// 모든 페이지 컨트롤러에 대해 조언을 수행하는 클래스 정의
// => 다음 애노테이션을 붙이면 프론트 컨트롤러는 페이지 컨트롤러를 실행하기 전에
//    먼저 이 클래스를 살펴볼 것이다.
@ControllerAdvice
public class Exam05_5_GlobalControllerAdvice {

    @InitBinder
    public void ititBinder(WebDataBinder binder) {
        // 이 메서드는 요청이 들어올 때 마다 파라미터 값을 준비하기 위해
        // 파라미터의 개수 만큼 호출된다.
        System.out.println("Exam05_5_GlobalControllerAdvice.initBinder() 호출");
    
        // java.lang.String ===> java.sql.Date로 변환시켜주는 프로퍼티 에디터 등록
        binder.registerCustomEditor(
                java.sql.Date.class, /* 요청 핸들러의 파라미터 타입 */
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        // "text" 파라미터는 클라이언트가 보낸 데이터이다.
                        // 이렇게 문자열로 보낸 데이터는 java.sql.Date 객체로 바꿔야 한다.
                        this.setValue(Date.valueOf(text));
                    }
                });
        binder.registerCustomEditor(
                egovframework.example.vo.Member.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        // 클라이언트가 csv 포맷으로 넘긴 회원 정보를
                        // Member 객체로 바꿀 수 있다.
                        // 예) hong,hong@test.com,1111
                        String[] values = text.split(",");
                        Member obj = new Member();
                        obj.setId(values[0]);
                        obj.setEmail(values[1]);
                        obj.setPassword(values[2]);
                        this.setValue(obj);
                    }
                });
    }
    
}
