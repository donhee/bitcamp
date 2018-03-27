package bitcamp.java106.pms.domain;

import java.sql.Date;

// Team 클래스
// => 팀 정보를 저장할 수 있는 메모리의 구조를 설계한 클래스이다.
// => 즉 팀 정보를 위해 사용자(=개발자)가 새로 정의한 데이터 타입이다.
// 
public class Team {
    private String name;
    private String description;
    private int maxQty;
    private Date startDate;
    private Date endDate;
    private Member[] members = new Member[10];
    // 사용자 정의 데이터 타입(클래스)에서 메서드 정의
    // => 새 데이터 타입의 값을 다룰 연산자를 정의하는 것을 의미한다.
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(int maxQty) {
        this.maxQty = maxQty;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Member[] getMembers() {
        return members;
    }

    // 연산자는 외부에서 사용하는 것이기 때문에 공개해야 한다.
    // => 그래서 public modifier를 사용한다.
    public int addMember(Member member) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) {
                this.members[i] = member;
                return 1;
            }
        }
        return 0;
    }
    
    public int deleteMember(String memberId) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (this.members[i].getId().equals(memberId)) {
                this.members[i] = null;
                return 1; // 함수 실행을 멈추고 그 다음 라인을 실행
            }
        }
        return 0;
    }
    // ver 17
    public Member getMember(String memberId) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (this.members[i].getId().equals(memberId)) {
                return this.members[i]; // 함수 실행을 멈추고 그 다음 라인을 실행
            }
        }
        return null;
    }
    
    public boolean isExist(String memberId) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (this.members[i].getId().equals(memberId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Team [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
    
    
    
}

// ver 17 - getMember() 메서드 추가.
//          toString() 오버라이딩(재정의).