package com.example.kickoff.model;

import jakarta.persistence.*;

@Entity
@Table(name="user_flyway")
public class UserFlyway {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   private String email;
   private String password;
   private String mobile;
   private boolean isMarried;

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UserFlyway() {
    }

    public UserFlyway(String name, String email, String password,String mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile=mobile;
    }

    public UserFlyway(long id, String name, String email, String password,String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile=mobile;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
