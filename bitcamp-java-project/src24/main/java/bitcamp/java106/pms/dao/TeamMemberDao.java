package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    private HashMap<String, ArrayList<String>> collection = new HashMap<>(); 
    
    public TeamMemberDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/teammember.csv"));
        while (true) {
            
            try {
                String[] arr = in.nextLine().split(":");
                String[] idList = arr[1].split(",");
                ArrayList<String> list = new ArrayList<>();
                for (String id : idList) {
                    list.add(id);
                }
                collection.put(arr[0], list);
            } catch (Exception e) {
                break;
            }
        }
        
        in.close();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/teammember.csv"));
        
        Set<String> keyList = this.collection.keySet();
        for (String key : keyList) {
            List<String> idList = collection.get(key);
            
            out.printf("%s:", key);
            for (String id : idList) {
                out.printf("%s,", id);
            }
            out.println();
        }
        out.close();
    }
    
    
    
    
    
    public int addMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null) { // 해당 팀의 멤버가 추가된 적이 없다면,
            members = new ArrayList<>();
            members.add(memberIdLC);
            collection.put(teamNameLC, members);
            // 컬렉션에               팀이름으로          members 주소를 저장
            return 1;
        }
        
        // ArrayList에 해당 아이디를 가진 멤버가 들어 있다면,
        if (members.contains(memberIdLC)) {
            return 0;
        }
        members.add(memberId.toLowerCase());
        
        collection.put(teamNameLC, members); 
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC)) {
            // 그 방의 주소가 없거나 or 그 방에 들어있는 memberIdLC 값이 없으면
            return 0;
        }
        members.remove(memberIdLC);
        return 1;
    }
    
    public Iterator<String> getMembers(String teamName) {
        ArrayList<String> members = collection.get(teamName.toLowerCase());
        if (members == null)
            return null;
        return members.iterator();
    }
        // 멤버의 목록을 관리하는 getMembers() 메소드 에는 TeamMemberController에게
        // 리턴 타입으로 ArrayList<String>을 하게 되면 ArrayList 를 통채로 주게 된다.
        // Iterator를 쓰는 이유는 그 안에 있는 메소드는 값을 꺼내는 hasNext(), next() 밖에
        // 없기 때문에 따로 add나 delete 등을 할 수가 없다.
    
    public boolean isExist(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC)) {
            return false;
        }
        return true;
    }
    
}    
    
// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.
// ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 추가
