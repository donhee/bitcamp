// 게시판 관리 - 목록
package step25.ex07;

import java.sql.DriverManager;

public class Exam01_list {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/java106db",
                "java106", 
                "1111");

        java.sql.Statement stmt = con.createStatement();
        
        java.sql.ResultSet rs = stmt.executeQuery(
                "select bno,titl,rdt from ex_board");
        
        while (rs.next()) {
            System.out.printf("%d,%s,%s\n", 
                    rs.getInt("bno"), 
                    rs.getString("titl"),
                    rs.getDate("rdt"));
        }
        
        // 자원해제
        // => 파일과 마찬가지로 DBMS에 연결한 후 더이상 사용하지 않으면 연결을 해제해야 한다.
        rs.close();
        stmt.close();
        con.close();
        
    }
}

