package com.games.prick.repository;

import com.games.prick.entity.Search;
import com.games.prick.entity.ServerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerIdRepository extends JpaRepository<ServerId, Long> {

}
