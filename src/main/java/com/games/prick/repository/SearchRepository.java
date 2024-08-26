package com.games.prick.repository;


import com.games.prick.entity.BasicInForEntity;
import com.games.prick.entity.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<SearchEntity, Long> {

}
