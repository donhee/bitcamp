// 게시글 데이터를 저장할 새 데이터 타입을 정의한다.
package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Board {
    private static int count = 1; // 자동으로 올라갈 변수
    private int no; // 게시물에 인덱스를 저장할 변수
    private String title;
    private String content;
    private Date createdDate;
    // 스태틱변수는 클래스가 로딩될때 한번 실행
    // 인스턴스 변수는 new 명령에 의해 생성
    public Board() {
        this.no = count++;
        // 게시물 객체가 만들어질 때마다 고유의 번호를 갖게한다.
    }
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        // 외부에서 입력 받은 번호가 count 보다 클 때는 count의 값을 증가시켜야 한다.
        if (no >= count) {
            count = no + 1;
        }
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
}

// ver 18 - 게시물 객체의 고유 번호를 static 변수를 이용하여 자동 생성한다. 
// ver 16 - 캡슐화 적용, 겟터, 셋터