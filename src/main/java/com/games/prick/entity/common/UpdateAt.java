package com.games.prick.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class UpdateAt extends CreatedAt{
    @LastModifiedDate//JPA 가 insert, update 때 현재 일시 값을 주입
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
