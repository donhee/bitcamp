package bitcamp.java106.pms.domain;

public class Member {
    private String id;
    private String email;
    private String password;
    
    // ver 24 - 
    public Member() {}
    
    public Member(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", email=" + email + ", password=" + password + "]";
    }
    
    
    
}

//ver 17 - toString() 재정의.