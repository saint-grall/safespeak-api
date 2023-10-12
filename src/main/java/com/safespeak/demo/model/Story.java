package com.safespeak.demo.model;

import com.safespeak.demo.enums.AnswerType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "story")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    private List<Reply> replies;

    @Enumerated(EnumType.STRING)
    @Column(name = "correct_answer")
    private AnswerType CorrectAnswer;

    @Column(name = "context")
    private String context;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getText() {
        return text;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public AnswerType getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(AnswerType correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
