package com.games.prick.repository;


import com.games.prick.entity.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInForRepository extends JpaRepository<BasicInfo, Long> {
}
