package com.games.prick.repository;


import com.games.prick.entity.common.CharacterIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantDataRepository extends JpaRepository<CharacterIdEntity, Long> {
}
