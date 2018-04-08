package bitcamp.java106.pms.dao;

import java.util.ArrayList;

import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Task;

@Component
public class TaskDao extends AbstractDao<Task>{
    
    // 기존의 list() 메서드로는 작업을 처리할 수 없기 때문에
    // 팀명으로 작업의 목록을 리턴해주는 메서드를 추가한다.
    // => 오버로딩 
    // 기존의 list와 차이점!!      파라미터 값을 받게 했다.
    public Iterator<Task> list(String teamName) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : this.collection) {
            if (task.getTeam().getName().equalsIgnoreCase(teamName)) {
                    tasks.add(task);
            }
        }    
        return tasks.iterator();
    }
    
    
    public int indexOf(Object key) {
        int taskNo = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            Task task = collection.get(i);
            if (task.getNo() == taskNo) {
                return i;
            }
        }
        return -1;
    }
}
// ver 17 - TaskDao 생성