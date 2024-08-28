package com.games.prick.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class BasicInFor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basicId;
    @Column(length = 20)
    private String serverId;
    @Column(length = 20)
    private String characterId;
}
