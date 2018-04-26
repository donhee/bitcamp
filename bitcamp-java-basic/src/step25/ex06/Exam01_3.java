// Mybatis - 자바 객체의 프로퍼티 이름과 컬럼명을 일치시키기 II
package step25.ex06;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam01_3 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex06/mybatis-config03.xml");
        
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);              
        SqlSession sqlSession = factory.openSession(); // openSession() : 객체를 생성해주는 메서드 : factory 패턴 적용
    
        List<Board> list = sqlSession.selectList("BoardMapper.selectBoard");
        
        for (Board board : list) {
            System.out.printf("%d, %s, %s, %s\n",
                board.getNo(), 
                board.getTitle(), 
                board.getContent(),
                board.getRegisteredDate());
        }
        
        sqlSession.close();
    }
}




