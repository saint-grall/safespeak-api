package com.safespeak.demo.dto;

import java.time.LocalDateTime;

public class StoryDto {
    private String text;
    private LocalDateTime createdAt; // You can pass this field when creating a new story

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}