// 게시글 데이터를 저장할 새 데이터 타입을 정의한다.
package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Board {
    public int no; // 게시물에 인덱스를 저장할 변수
    public String title;
    public String content;
    public Date createdDate;
}
