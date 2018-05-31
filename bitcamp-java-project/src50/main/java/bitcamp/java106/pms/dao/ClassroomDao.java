package bitcamp.java106.pms.dao;

import java.util.List;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomDao {
    
    public int delete(int no);
    public List<Classroom> selectList();
    public Classroom selectOne(int no);
    public int insert(Classroom classroom);
    public int update(Classroom classroom);

}
// ver 50 - 클래스를 인터페이스로 변경
// ver 33 - Mybatis 적용
//ver 32 - DB Connection Pool 적용
//ver 31 - JDBC API 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




