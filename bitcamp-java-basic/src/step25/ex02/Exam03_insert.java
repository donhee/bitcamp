// classroom - 등록 + PreparedStatement
package step25.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam03_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("시작일? ");
        String startDate = keyScan.nextLine();
        
        System.out.print("종료일? ");
        String endDate = keyScan.nextLine();
        
        System.out.print("교실명? ");
        String room = keyScan.nextLine();
        
        // JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // DBMS에 연결하기
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106",
                "1111");
        
        // SQL문을 서버에 보낼 객체를 얻는다.
        PreparedStatement stmt = con.prepareStatement(
                "insert into ex_classroom(titl,sd,ed,room) values(?,?,?,?)");
    
        stmt.setString(1, title);
        stmt.setString(2, startDate);
        stmt.setString(3, endDate);
        stmt.setString(4, room);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}
