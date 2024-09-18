package com.games.prick.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ServerId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String serverId;
    @Column(length = 20)
    private String serverName;

    public ServerId( String serverId, String serverName) {
        this.serverId = serverId;
        this.serverName = serverName;
    }

    public ServerId() {

    }
}

