package com.games.prick.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
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
