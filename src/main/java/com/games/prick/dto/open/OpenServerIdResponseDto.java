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
public class OpenServerIdResponseDto extends ResponseDto {
    String serverId;
    String serverName;


    private OpenServerIdResponseDto(String serverId, String serverName) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.serverId = serverId;
        this.serverName = serverName;

    }

    public static ResponseEntity<ResponseDto> success(String serverId, String serverName) {
        OpenServerIdResponseDto result = new OpenServerIdResponseDto(serverId, serverName);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    }

