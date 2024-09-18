package com.games.prick.repository;

import com.games.prick.entity.Avatar;
import com.games.prick.entity.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
