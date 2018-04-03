package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao extends AbstractDao<Team> {
    
    public int indexOf(Object key) {
        String name = (String) key;
        for (int i = 0; i < collection.size(); i++) {
            if (name.toLowerCase().equals(
                   collection.get(i).getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}