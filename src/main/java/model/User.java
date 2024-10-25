package model;

import java.util.List;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone_no;
    private List<Claim> claims; 

    public User(int userId, String username, String password, String email, String address, String phoneNo, List<Claim> claims, String phone_no) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone_no = phone_no;
        this.claims = claims;
    }
    
    public User(String username, String password, String email, String phone_no) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_no = phone_no;
    }
    
    public User() {
    	   
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phone_no;
    }

    public void setPhoneNo(String phoneNo) {
        this.phone_no = phoneNo;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
}
