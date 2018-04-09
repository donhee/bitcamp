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
    
    //ver - 24
    public Team() {}
    
    public Team(String name) {
        this.name = name;
    }
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

    @Override
    public String toString() {
        return "Team [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}

// ver 17 - 팀 멤버 관련 메서드를 TeamMemberDao로 옮긴다.
//          toString() 오버라이딩(재정의).