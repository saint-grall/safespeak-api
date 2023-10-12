package com.safespeak.demo.model;

import com.safespeak.demo.enums.UserRole;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER_ROLE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Story> stories = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    // Constructors, getters, setters, etc.
}
