package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private static int count = 1;
    
    private int no; // 작업 번호 // 내부적으로 쓰기 위한 변수
    private String title;
    private Date startDate;
    private Date endDate;
    private int state; // 0: 작업대기, 1: 작업중, 9: 완료
    private Member worker;
    private Team team;
    
    // 어느 팀에 소속되어있는지
    public Task(Team team) {
        this.team = team;
        this.no= count++;
    }
    
    public Task(Team team, String title, Date startDate, Date endDate) {
        //this.no= count++;
        //this.team = team;
        // 같은 코드 
        this(team);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = READY;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
    public Member getWorker() {
        return worker;
    }
    public void setWorker(Member worker) {
        this.worker = worker;
    }
    
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state
                + ", worker=" + worker + ", team=" + team + "]";
    }
    
    
    
    
}

// ver 17 - 사용자 정의 데이터 타입 생성 