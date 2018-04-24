// member - 조회 + PreparedStatement
package stetp25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam04_view {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("조회할 회원은? ");
        String id = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");

        PreparedStatement stmt = con.prepareStatement(
                "select bid,email,pw from ex_member where bid=?");
        stmt.setString(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("아이디: %s\n", rs.getString("bid")); 
            System.out.printf("이메일: %s\n", rs.getString("email"));
            System.out.printf("패스워드: %s\n", rs.getString("pw"));
        } else {
            System.out.println("해당 회원이 없습니다.");
        }
        
        rs.close();
        stmt.close();
        con.close();
        keyScan.close();
    }
}
