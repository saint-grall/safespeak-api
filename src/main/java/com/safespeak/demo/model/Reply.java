package com.safespeak.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "reply_answers", joinColumns = @JoinColumn(name = "reply_id"))
    @Column(name = "answer")
    private List<Boolean> answers;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Boolean> answers) {
        this.answers = answers;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
