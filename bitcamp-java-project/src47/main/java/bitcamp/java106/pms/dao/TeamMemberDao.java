package bitcamp.java106.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Member;

@Component
public class TeamMemberDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public TeamMemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(String teamName, String memberId) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            paramMap.put("memberId", memberId);
            
            int count =  sqlSession.insert(
                    "bitcamp.java106.pms.dao.TeamMemberDao.insert", paramMap);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(String teamName, String memberId) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            paramMap.put("memberId", memberId);
            
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.TeamMemberDao.delete", paramMap);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(String teamName) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.TeamMemberDao.delete", paramMap);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<String> selectList(String teamName) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.TeamMemberDao.selectList", teamName);
        }
    }
    
    public List<Member> selectListWithEmail(String teamName) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.TeamMemberDao.selectListWithEmail", teamName);
        }
    }
    
    public boolean isExist(String teamName, String memberId) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            paramMap.put("memberId", memberId);
            
            int count = sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.TeamMemberDao.isExist", paramMap);
            if (count > 0)
                return true;
            else 
                return false;
        }
    }
}
// ver 33 - Mybatis를 적용
//ver 32 - DB Connection Pool 적용
//ver 31 - JDBC API 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 17 - 클래스 추가






