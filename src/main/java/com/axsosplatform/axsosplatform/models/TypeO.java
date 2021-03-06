package com.axsosplatform.axsosplatform.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="typeo")
public class TypeO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    public String kind;

    @OneToMany(mappedBy="typeO", fetch = FetchType.LAZY)
    private List<QuestionPost> questionPosts;

    public List<QuestionPost> getQuestionPosts() {
        return questionPosts;
    }

    public void setQuestionPosts(List<QuestionPost> questionPosts) {
        this.questionPosts = questionPosts;
    }

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    public TypeO() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


}
