package com.games.prick.repository;

import com.games.prick.entity.BasicInFor;
import com.games.prick.entity.ServerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenDataRepository extends JpaRepository<ServerId, Long> {
}
