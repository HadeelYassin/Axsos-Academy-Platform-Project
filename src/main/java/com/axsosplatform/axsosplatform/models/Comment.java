package com.axsosplatform.axsosplatform.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User commentCreator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="qp_id")
    private QuestionPost qpost;


    public Comment() {
    }

    public User getCommentCreator() {
        return commentCreator;
    }

    public void setCommentCreator(User commentCreator) {
        this.commentCreator = commentCreator;
    }

    public QuestionPost getQpost() {
        return qpost;
    }

    public void setQpost(QuestionPost questionPost) {
        this.qpost = questionPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
