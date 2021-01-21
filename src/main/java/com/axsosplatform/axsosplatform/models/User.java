package com.axsosplatform.axsosplatform.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Size(min=3, message="Username must be greater than 3 characters")
    private String username;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<QuestionPost> questionPosts;


    @OneToMany(mappedBy="commentCreator", fetch = FetchType.LAZY)
    private List<Comment> comments;


    public User() {
    }


    public List<QuestionPost> getQuestionPosts() {
        return questionPosts;
    }

    public void setQuestionPosts(List<QuestionPost> questionPosts) {
        this.questionPosts = questionPosts;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public String genaratePassword(){
        String aToz="qwertyuioplkjhgfdsazxcvbnm";
        String AtoZ="QAZWSXEDCRFVTGBYHNUJMIKLOP";
        String specialChar="!#$^*&";
        Random r= new Random();
        int a_z=r.nextInt(25);
        int num=r.nextInt(5);
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < 3; i++) {
            a_z=r.nextInt(25);
            num=r.nextInt(5);
            sb.append(aToz.charAt(a_z));
            sb.append(AtoZ.charAt(a_z));
            sb.append(specialChar.charAt(num));
        }
        return sb.toString();

    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
