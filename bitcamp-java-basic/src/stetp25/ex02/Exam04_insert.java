// member - 등록 + PreparedStatement
package stetp25.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam04_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("아이디? ");
        String id = keyScan.nextLine();
        
        System.out.print("이메일? ");
        String email = keyScan.nextLine();
        
        System.out.print("패스워드? ");
        String password = keyScan.nextLine();
        
        // JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // DBMS에 연결하기
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106",
                "1111");
        
        // SQL문을 서버에 보낼 객체를 얻는다.
        PreparedStatement stmt = con.prepareStatement(
                "insert into ex_member(bid,email,pw) values(?,?,?)");
    
        stmt.setString(1, id);
        stmt.setString(2, email);
        stmt.setString(3, password);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}
