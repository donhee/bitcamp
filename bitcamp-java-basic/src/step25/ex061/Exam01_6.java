// Mybatis - select 컬럼과 프로퍼티
package step25.ex061;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import step25.ex06.Board;

public class Exam01_6 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex061/mybatis-config06.xml");
        
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);              
        SqlSession sqlSession = factory.openSession(); // openSession() : 객체를 생성해주는 메서드 : factory 패턴 적용
        
        Board board = new Board();
        board.setTitle("제목입니당!");
        board.setContent("내용입니당!");

        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.println("--------------------------------------");
        
        int count = sqlSession.insert("BoardMapper.insertBoard", board);
        System.out.println(count);
        
        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        
        sqlSession.commit();
        
        sqlSession.close();
    }
}





