package com.starco.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private LocalDateTime cratedAt;
    private LocalDateTime updateAt;

    public User(){

    }
    public User(String fullName,
                String email,
                String phone,
                String role,
                LocalDateTime cratedAt,
                LocalDateTime updateAt) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.cratedAt = cratedAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
