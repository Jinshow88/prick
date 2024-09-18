package com.games.prick.repository;

import com.games.prick.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuffEquipmentRepository extends JpaRepository<Avatar, Long> {
}
