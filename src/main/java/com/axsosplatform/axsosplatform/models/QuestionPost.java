package com.axsosplatform.axsosplatform.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="qposts")
public class QuestionPost {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private  String title;

    @Lob
    @Column(name="BODY", length=512)
    private String  body;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id")
    private TypeO typeO;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "qp_tags",
            joinColumns = @JoinColumn(name = "qp_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @OneToMany(mappedBy="qpost", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public QuestionPost() {
    }

    public QuestionPost(Long id, String body,String title) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public QuestionPost(String body, String title) {
        this.title = title;
        this.body = body;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public TypeO getTypeO() {
        return typeO;
    }

    public void setTypeO(TypeO typeO) {
        this.typeO = typeO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
