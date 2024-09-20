package com.games.prick.repository;


import com.games.prick.entity.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfo, Long> {


    @Query(value =

            "SELECT character_id " +
                    "FROM search " +
                    "WHERE character_name = :characterName " +
                    "AND server_id = ( " +
                    "SELECT server_id " +
                    "FROM SERVER " +
                    "WHERE server_name = :serverName) ",

            nativeQuery = true)
    String getCharacter(String characterName, String serverName);

    @Query(value =
            "SELECT server_id FROM SERVER " +
                    "WHERE server_name = :serverName ",
            nativeQuery = true)
    String getServer(String serverName);
}
