// classroom - 목록 + PreparedStatement
package stetp25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam03_list {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");

        PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,sd,ed,room from ex_classroom");
        
        // SQL을 실행할 때는 파라미터로 SQL문을 넘겨주지 않는다.
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%d,%s,%s,%s,%s\n", 
                    rs.getInt("bno"), 
                    rs.getString("titl"),
                    rs.getDate("sd"),
                    rs.getDate("ed"),
                    rs.getString("room"));
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}
