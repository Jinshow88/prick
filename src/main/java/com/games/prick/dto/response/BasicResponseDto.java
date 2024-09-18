package com.games.prick.dto.response;

import com.games.prick.dto.ResponseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.games.prick.common.GlobalConst.SUCCESS_CODE;
import static com.games.prick.common.GlobalConst.SUCCESS_MESSAGE;

@Slf4j
@Getter
@Setter
@SuperBuilder
@ToString
public class BasicResponseDto extends ResponseDto {
    String serverId;
    String characterId;
    String characterName;
    String level;
    String jobId;
    String jobGrowId;
    String jobName;
    String jobGrowName;
    String fame;
    String adventureName;
    String guildId;
    String guildName;

    private BasicResponseDto(String serverId, String characterId, String characterName, String level,
                             String jobId, String jobGrowId, String jobName, String jobGrowName, String fame
                                  , String adventureName, String guildId, String guildName) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.serverId = serverId;
        this.characterId = characterId;
        this.characterName = characterName;
        this.level = level;
        this.jobId = jobId;
        this.jobGrowId = jobGrowId;
        this.jobName = jobName;
        this.jobGrowName = jobGrowName;
        this.fame = fame;
        this.adventureName = adventureName;
        this.guildId = guildId;
        this.guildName = guildName;
    }

    public static ResponseEntity<ResponseDto> success(String serverId, String characterId, String characterName, String level,
                                                      String jobId, String jobGrowId, String jobName, String jobGrowName, String fame
            ,String adventureName, String guildId, String guildName) {
        BasicResponseDto result = new BasicResponseDto(serverId, characterId, characterName, level,
                jobId, jobGrowId, jobName, jobGrowName, fame,adventureName,guildId,guildName);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

