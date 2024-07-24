package com.example.prick.entity;

import jakarta.persistence.*;

public class Feed {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(length = 1000)
    private String contents;

    @Column(length = 100)
    private String location;
}
