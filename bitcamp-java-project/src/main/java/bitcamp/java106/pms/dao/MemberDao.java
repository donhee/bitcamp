package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao extends AbstractDao<Member> {
    
    public int indexOf(Object key) {
        String id = (String) key;
        for (int i = 0; i < collection.size(); i++) {
            Member originmember = collection.get(i);
            if (originmember.getId().toLowerCase().equals(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
}
