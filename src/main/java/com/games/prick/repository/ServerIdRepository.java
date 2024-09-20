package com.games.prick.repository;

import com.games.prick.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerIdRepository extends JpaRepository<Server, Long> {

}
