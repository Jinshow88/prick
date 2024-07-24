package com.example.prick.entity;

import jakarta.persistence.*;

public class FeedEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

    @Column(length = 1000)
    private String contents;

    @Column(length = 100)
    private String location;
}
