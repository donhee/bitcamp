package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Task;

public interface TaskDao {
    
    public int delete(int no);    
    public int deleteByTeam(String teamName);
    public List<Task> selectList(String teamName);    
    public int insert(Task task);
    public int update(Task task);
    public Task selectOne(int no);
    public int updateState(Map<String,Object> map);
    
}
// ver 50 - 클래스를 인터페이스로 변경
//ver 32 - DB Connection Pool 적용
//ver 31 - JDBC API 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





