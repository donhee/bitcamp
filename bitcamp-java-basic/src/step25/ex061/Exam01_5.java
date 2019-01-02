// Mybatis - select 컬럼과 프로퍼티
package step25.ex061;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam01_5 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex061/mybatis-config05.xml");
        
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);              
        SqlSession sqlSession = factory.openSession(); // openSession() : 객체를 생성해주는 메서드 : factory 패턴 적용
        
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("limitSQL", "limit 9, 5");
        paramMap.put("pageSize", 3);
        
        List<Board> list = sqlSession.selectList("BoardMapper.selectBoard", paramMap);
        // ex) selectList(SQL문이름, 파라미터값)
        //     - SQL문 이름 = 그룹명(namespace) + "." + SQL문장 아이디
        //     - 파라미터 값 = primitive type 및 모든 자바 객체가 가능
        //                  여러 개의 값을 전달할 때는 Map에 담아 넘겨라
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





