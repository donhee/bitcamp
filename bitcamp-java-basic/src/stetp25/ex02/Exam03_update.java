// classroom - 변경 + PreparedStatement 
package stetp25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam03_update {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("변경할 교실 번호는? ");
        String no = keyScan.nextLine();
        
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("교실명? ");
        String room = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");

        PreparedStatement stmt = con.prepareStatement(
                "update ex_classroom set titl=?,room=? where bno=?");
        stmt.setString(1, title);
        stmt.setString(2, room);
        stmt.setString(3, no); 
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 변경 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}
