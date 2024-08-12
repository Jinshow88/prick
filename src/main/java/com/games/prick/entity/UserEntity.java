package com.games.prick.entity;

import com.games.prick.entity.common.UpdateAt;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserEntity extends UpdateAt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

//    @ColumnDefault("4")
//    @Column(nullable = false)
//    private SignInProviderType providerType;

    @Column(length = 50, nullable = false)
    private String uid;

    @Column(length = 100, nullable = false)
    private String upw;

    @Column(length = 50, nullable = false)
    private String nm;

    @Column(length = 200)
    private String pic;


}
