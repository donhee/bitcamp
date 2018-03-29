package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public class TeamMemberDao {
    
    private Object[][] teamMembers = new Object[1000][2];
    private int rowIndex; // 현재 위치 // 값을 설정하지 않아도 초기화 0
    
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase(); // 파라미터 teamName
        String pmi = memberId.toLowerCase(); // 파라미터 memberId
        for (int i = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) continue;
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            String mi = ((String)this.teamMembers[i][1]).toLowerCase();
            if (tn.equals(ptn) && mi.equals(pmi)) {
                return i;
            }
        }
        return -1; // 인덱스이기 때문에 0을 리턴하면 값이 있다는것. 그래서 음수를 사용해야함
    }
    
    public int addMember(String teamName, String memberId) {
        if (this.isExist(teamName, memberId)) { // 이미 존재하는 멤버라면,
            return 0; // 0을 리턴 . add시키지 않은 것
        }
        this.teamMembers[rowIndex][0] = teamName; // 사용자가 입력한 값 그대로 저장 (대소문자 구별없이)
        this.teamMembers[rowIndex][1] = memberId;
        rowIndex++;
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if (index < 0) { // 존재하지 않는 멤버라면,
            return 0; // 
        }
        this.teamMembers[index][0] = null;
        this.teamMembers[index][1] = null;
        return 1; // 지운것
    }
    
    public boolean isExist(String teamName, String memberId) {
        if (this.getIndex(teamName, memberId) < 0) {
            return false;
        } else {
            return true;
        }
    }

    private int getMemberCount(String teamName) {
        int cnt = 0; // 로컬 변수는 자동으로 0으로 초기화 되지 않는다. // 반드시 초기화 시켜라!
        String ptn = teamName.toLowerCase(); // 파라미터 teamName
        
        for (int i = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) 
                continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            if (tn.equals(ptn)) { // 원래 팀 정보와 파라미터로 받은 teamName이 같으면
                cnt++; // cnt를 증가시켜라
            }
        }
        return cnt;
    }
    
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase(); // 파라미터 teamName 을 소문자로 바꿔라
        String[] members = new String[this.getMemberCount(teamName)]; // teamName을 받아서 개수만큼 배열을 준비
        
        for (int i = 0, x = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) 
                continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase(); // 팀 이름을 가져와서
            if (tn.equals(ptn)) { // 원래 팀 이름와 파라미터로 받은 teamName이 같으면
                members[x++] = (String)this.teamMembers[i][1];
            }
        }
        return members;
    }
}
// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.
// ver 17 - 클래스 추가
