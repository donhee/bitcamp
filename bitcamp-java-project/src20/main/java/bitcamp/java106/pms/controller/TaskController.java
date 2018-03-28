// 팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
 
public class TaskController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // keyScan 변수에 저장하라!
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao, TaskDao taskDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            this.onTaskList(option);
        } else if (menu.equals("task/view")) {
            //this.onTeamView(option);
        } else if (menu.equals("task/update")) {
            //this.onTeamUpdate(option);
        } else if (menu.equals("task/delete")) {
            //this.onTeamDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    private void onTaskAdd(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", teamName);
            return; // 메서드 호출을 끝내는것
        }
        // 어느 팀의 작업인지 지정
        Task task = new Task(team); 
        task.setTeam(team);
        
        System.out.println("[팀 작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());

        System.out.print("시작일? ");
        String str = keyScan.nextLine(); // keyScan으로 입력받을 변수 str을 선언한다.
        if (str.length() == 0) { // 만약 시작일을 입력하지 않으면  // str의 길이가 0일때 = 입력하지 않았을때!
            task.setStartDate(team.getStartDate()); // 팀 시작일을 사용한다.
        } else { 
            Date date = Date.valueOf(str); // date 비교 
            if ( date.getTime() < team.getStartDate().getTime()) {  // 시작일이 팀 시작일보다 이전이면 
                task.setStartDate(team.getStartDate()); // 팀 시작일을 값으로 사용
            } else { // 아니면 
                task.setStartDate(date); 
            }
        }
        
        System.out.print("종료일? ");
        str = keyScan.nextLine();
        if (str.length() == 0) { // 만약 종료일을 지정하지 않으면 팀 종료일을 사용한다.
            task.setEndDate(team.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) { // 종료일 > 팀 종료일 
                task.setEndDate(team.getEndDate());// 팀 종료일 값을 넣어라
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.print("작업자 아이디? ");
        String memberId = keyScan.nextLine();
        if (memberId.length() != 0) { // 입력된 값이 있으면
             Member member = team.getMember(memberId);
             if (member == null) {
                 System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다", memberId);
             } else {
                 task.setWorker(member);
             }
        }
        taskDao.insert(task);
    }
    
    private void onTaskList(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", teamName);
            return; // 메서드 호출을 끝내는것
        }
        
        System.out.println("[팀 작업 목록]");
        
        Task[] tasks = taskDao.list(team.getName());
        
        for (Task task : tasks) {
            System.out.printf("%d, %s, %s, %s, %s\n",
                    task.getNo(), task.getTitle(),
                    task.getStartDate(), task.getEndDate(),
                    (task.getWorker() == null) ? "-" : task.getWorker().getId());
        }
    }
    /*
    void onTeamView(String name) {
        System.out.println("[팀 정보 조회]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }
        
        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명: %s\n", team.getName());
            System.out.printf("설명: %s\n", team.getDescription());
            System.out.printf("최대인원: %d\n", team.getMaxQty());
            System.out.printf("기간: %s ~ %s\n", 
                team.getStartDate(), team.getEndDate());
        }
    }

    void onTeamUpdate(String name) {
        System.out.println("[팀 정보 변경]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        
        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            //Team team = teams[i];
            Team updateTeam = new Team();
            System.out.printf("팀명? %s\n", team.getName());
            //updateTeam.name = keyScan.nextLine();
            updateTeam.setName(team.getName());
            System.out.printf("설명(%s)? ", team.getDescription());
            updateTeam.setDescription(keyScan.nextLine());
            System.out.printf("최대인원(%d)? ", team.getMaxQty());
            updateTeam.setMaxQty(keyScan.nextInt());
            keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.getStartDate());
            updateTeam.setStartDate(Date.valueOf(this.keyScan.nextLine()));
            System.out.printf("종료일(%s)? ", team.getEndDate());
            updateTeam.setEndDate(Date.valueOf(this.keyScan.nextLine()));
            //this.teams[i] = updateTeam;
            teamDao.update(updateTeam);
            System.out.println("변경하였습니다.");
        }
    }
            
    void onTeamDelete(String name) {
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        
        Team team = teamDao.get(name);
        
        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                //teams[i] = null;
                teamDao.delete(name);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    */
}