package com.games.prick.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Setter
@Getter
@Entity
public class BasicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String serverId;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false) @Comment("객실 ID")
    private Search characterId;
    @Column(length = 30)
    private String characterName;
    @Column(length = 20)
    private String level;
    @Column(length = 50)
    private String jobId;
    @Column(length = 50)
    private String jobGrowId;
    @Column(length = 30)
    private String jobName;
    @Column(length = 30)
    private String jobGrowName;
    @Column(length = 20)
    private String fame;
    @Column(length = 30)
    private String adventureName;
    @Column(length = 50)
    private String guildId;
    @Column(length = 30)
    private String guildName;


    public BasicInfo(String serverId, Search characterId, String characterName, String level, String jobId
            , String jobGrowId, String jobName, String jobGrowName, String fame, String adventureName
            , String guildId, String guildName) {
        this.serverId = serverId;
        this.characterId = characterId;
        this.characterName = characterName;
        this.level = level;
        this.jobId = jobId;
        this.jobGrowId = jobGrowId;
        this.jobName = jobName;
        this.jobGrowName = jobGrowName;
        this.adventureName = adventureName;
        this.fame = fame;
        this.guildId = guildId;
        this.guildName = guildName;


    }

    public BasicInfo() {

    }
}
