package com.games.prick.dto.response;

import com.games.prick.dto.ResponseDto;
import com.games.prick.dto.object.SearcResult;
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
public class SearchResponseDto extends ResponseDto {
    String serverId;
    String characterId;
    String characterName;
    String level;
    String jobId;
    String jobGrowId;
    String jobName;
    String jobGrowName;
    String fame;


    private SearchResponseDto(SearcResult searcResult) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.serverId = searcResult.getServerId();
        this.characterId = searcResult.getCharacterId();
        this.characterName = searcResult.getCharacterName();
        this.level = searcResult.getLevel();
        this.jobId = searcResult.getJobId();
        this.jobGrowId = searcResult.getJobGrowId();
        this.jobName = searcResult.getJobName();
        this.jobGrowName = searcResult.getJobGrowName();
        this.fame = searcResult.getFame();


    }

    public static ResponseEntity<ResponseDto> success(SearcResult searcResult) {
        SearchResponseDto result = new SearchResponseDto(searcResult);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}


