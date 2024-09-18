package com.games.prick.dto.response;

import com.games.prick.dto.ResponseDto;
import com.games.prick.dto.object.ServerDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.games.prick.common.GlobalConst.SUCCESS_CODE;
import static com.games.prick.common.GlobalConst.SUCCESS_MESSAGE;

@Slf4j
@Getter
@Setter
@SuperBuilder
@ToString
public class ServerIdResponseDto extends ResponseDto {
    //    String serverId;
//    String serverName;
    private List<ServerDto> rows;

    private ServerIdResponseDto(List<ServerDto> rows) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
//        this.serverId = serverId;
//        this.serverName = serverName;
        this.rows = rows;

    }

    public static ResponseEntity<ResponseDto> success(List<ServerDto> rows) {
        ServerIdResponseDto result = new ServerIdResponseDto(rows);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

