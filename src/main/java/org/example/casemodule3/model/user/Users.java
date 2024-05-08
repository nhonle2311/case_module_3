package org.example.casemodule3.model.user;

import java.sql.Timestamp;

public class Users {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private Timestamp createdAt;

    public Users() {
    }

    public Users(int id, String userName, String password, String email, String fullName, Timestamp createdAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.createdAt = createdAt;
    }

    public Users(String userName, String password, String email, String fullName, Timestamp createdAt) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
