package com.games.prick.repository;


import com.games.prick.entity.BasicInFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInForRepository extends JpaRepository<BasicInFor, Long> {
}
