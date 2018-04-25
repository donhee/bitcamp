package stetp25.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    
    public int delete(String id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");
            
            PreparedStatement stmt = con.prepareStatement(
                    "delete from ex_member where bid=?")) {
            
            stmt.setString(1, id);
            
            return stmt.executeUpdate();   
        }
    }

    public List<Member> list() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");

            PreparedStatement stmt = con.prepareStatement(
                "select bid,email,pw from ex_member")) {
        
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<Member> arr = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("bid"));
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("pw"));
                arr.add(member);
            }
            return arr;
        }
         
    }

    public int insert(Member member) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106",
                "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "insert into ex_member(bid,email,pw) values(?,?,?)");) {
    
        stmt.setString(1, member.getId());
        stmt.setString(2, member.getEmail());
        stmt.setString(3, member.getPassword());
        
        return stmt.executeUpdate();
        }
    }

    public Member view(String id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");
    
            PreparedStatement stmt = con.prepareStatement(
                "select bid,email,pw from ex_member where bid=?");) {
            
            stmt.setString(1, id);
            
            
            try ( ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
               
                Member member = new Member();
                member.setId(rs.getString("bid")); 
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("pw"));
                return member;
            }
        } 
    }
    
    public int update(Member member) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (
            java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", 
                "1111");
    
            PreparedStatement stmt = con.prepareStatement(
                "update ex_member set email=?,pw=? where bid=?");) {
            
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getId()); 
            
            return stmt.executeUpdate();
        }
        
    }
    
    
    
}
