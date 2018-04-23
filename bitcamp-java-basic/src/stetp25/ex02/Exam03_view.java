// classroom - 조회 + PreparedStatement
package stetp25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam03_view {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("조회할 교실 번호? ");
        String no = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");

        PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,sd,ed,room from ex_classroom where bno=?");
        stmt.setString(1, no); // 번호인데도 setString 해도 괜찮다.
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("번호: %d\n", rs.getInt("bno")); 
            System.out.printf("제목: %s\n", rs.getString("titl"));
            System.out.printf("시작일: %s\n", rs.getDate("sd"));
            System.out.printf("종료일: %s\n", rs.getDate("ed"));
            System.out.printf("교실명: %s\n", rs.getString("room"));
        } else {
            System.out.println("해당 교실 번호가 없습니다.");
        }
        
        rs.close();
        stmt.close();
        con.close();
        keyScan.close();
    }
}
