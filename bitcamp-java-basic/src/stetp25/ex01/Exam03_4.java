// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : select
package stetp25.ex01;

import java.sql.DriverManager;

public class Exam03_4 {
    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        // 2) DBMS에 연결하기
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");
        System.out.println("DBMS와 연결됨!");
        
        // 3) SQL문을 서버에 보낼 객체를 얻는다.
        //    - 리턴 값은 SQL문을 DBMS의 형식에 따라 인코딩하여 서버에 전달하는 일을 하는 객체.
        java.sql.Statement stmt = con.createStatement();
        
        // 4) Statement 객체를 사용하여 DBMS에 SQL문을 보낸다.
        //    => 리턴 값 : 결과가 아니다! 서버에서 결과를 가져오는 일을 할 객체를 리턴한다.
        // => 아직 결과를 가져온 상태가 아니다.
        java.sql.ResultSet rs = stmt.executeQuery(
                "select bno,titl,cont,rdt from ex_board");
        // 아직 서버에서 결과를 가져오지 못했다.
        
        // 5) ResultSet 객체를 사용하여 서버에서 select의 결과 한 레코드(row)를 가져온다.
        // 용어정리
        // 레코드(recode) : select를 실행한 후 생성된 결과이다.
        
        // 출력
        while (rs.next()) {
            System.out.printf("%d,%s,%s,%s\n", 
                    rs.getInt("bno"), 
                    rs.getString("titl"),
                    rs.getString("cont"), 
                    rs.getDate("rdt"));
            
            // DBMS에 설정된 컬럼의 타입에 따라 getXxx)를 호출하면 된다.
            // int, number        => getInt()
            // char,varchar, text => getString()
            // date, datetime     => getDate()
            // float              => getFloat()
            // 등등
            // 물론 컬럼의 타입과 상관없이 getString()으로 값을 꺼낼 수 있다.
        }
        
        // 자원해제
        // => 파일과 마찬가지로 DBMS에 연결한 후 더이상 사용하지 않으면 연결을 해제해야 한다.
        rs.close();
        stmt.close();
        con.close();
        
    }
}

