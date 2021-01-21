package com.axsosplatform.axsosplatform.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

@Size(min=20)
    private String description;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @Size(min=1)
    private  String label;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "qp_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "qp_id")
    )
    private List<QuestionPost> questionPosts;

    public Tag() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<QuestionPost> getQuestionPosts() {
        return questionPosts;
    }

    public void setQuestionPosts(List<QuestionPost> questionPosts) {
        this.questionPosts = questionPosts;
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
