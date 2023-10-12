package com.safespeak.demo.enums;

public enum AnswerType {
    FLIRT("Flirt"),
    SEXUAL_ASSAULT("Sexual Assault"),
    SEXUAL_HARASSMENT("Sexual Harassment"),
    NOTHING("Nothing");
    private final String label;

    AnswerType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
