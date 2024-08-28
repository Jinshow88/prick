package com.games.prick.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long searchId;
    @Column(length = 20)
    private String serverId;
    @Column(length = 20)
    private String characterName;
}

