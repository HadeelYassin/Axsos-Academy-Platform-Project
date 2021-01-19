package com.axsosplatform.axsosplatform.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //  student role
    private int role;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;


    @OneToMany(mappedBy="role", fetch = FetchType.LAZY)
    private List<User> user;

    public UserRole(){}


    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
