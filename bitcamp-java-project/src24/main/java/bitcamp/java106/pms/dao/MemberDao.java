package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao extends AbstractDao<Member> {
    
    public MemberDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/member.csv"));
        while (true) {
            try {
                String[] arr = in.nextLine().split(",");
                Member member = new Member();
                member.setId(arr[0]);
                member.setEmail(arr[1]);
                member.setPassword(arr[2]);
                this.insert(member);
            } catch (Exception e) {
                break;
            }
        }
        in.close();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/member.csv"));
        
        Iterator<Member> members = this.list();
        
        while (members.hasNext()) {
            Member member = members.next();
            out.printf("%s,%s,%s\n", member.getId(), member.getEmail(), member.getPassword());
        }
        out.close();
    }
    
    
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