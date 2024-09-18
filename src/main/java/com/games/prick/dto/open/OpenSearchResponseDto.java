package com.games.prick.dto.open;

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
public class OpenSearchResponseDto extends ResponseDto {
    String serverId;
    String characterId;
    String characterName;
    String level;
    String jobId;
    String jobGrowId;
    String jobName;
    String jobGrowName;
    String fame;


    private OpenSearchResponseDto(String serverId, String characterId, String characterName, String level,
                                  String jobId, String jobGrowId, String jobName, String jobGrowName, String fame) {
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


    }

    public static ResponseEntity<ResponseDto> success(String serverId, String characterId, String characterName, String level,
                                                      String jobId, String jobGrowId, String jobName, String jobGrowName, String fame) {
        OpenSearchResponseDto result = new OpenSearchResponseDto(serverId, characterId, characterName, level,
                jobId, jobGrowId, jobName, jobGrowName, fame);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}


