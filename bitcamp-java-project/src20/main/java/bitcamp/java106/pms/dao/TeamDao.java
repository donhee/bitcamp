package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    
    public void insert(Team team) {
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.teamIndex];
        for (int i = 0; i < this.teamIndex; i++) 
            arr[i] = this.teams[i];
        return arr;
    }
    
    public Team get(String name) {       
        int i = this.getTeamIndex(name);
        if (i == -1)
            return null;
        return this.teams[i];
    }
    
    public void update(Team team) {
        int i = this.getTeamIndex(team.getName());
        if (i != -1)
            this.teams[i] = team;
//        for (int i = 0; i < teamIndex; i++) {
//            if (this.teams[i] == null) continue;
//            if (team.name.equals(teams[i].name.toLowerCase())) {
//                this.teams[i] = team;
//                break;
//            }
//        }
    }
    
    public void delete(String name) {
        int i = this.getTeamIndex(name);
        if (i != -1)
            this.teams[i] = null;
//        for (int i = 0; i < teamIndex; i++) {
//            if (this.teams[i] == null) continue;
//            if (name.equals(teams[i].name.toLowerCase())) {
//                this.teams[i] = null;
//                break;
//            }
//        }
    }
    // 다음 메서드는 내부에서만 사용할 것이기 때문에 공개하지 않는다.
    private int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
   
}