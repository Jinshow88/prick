package com.games.prick.dto.open;

import com.games.prick.dto.ResponseDto;
import com.games.prick.dto.object.GetServer;
import com.games.prick.dto.response.ServerIdResponseDto;
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
public class OpenServerIdResponseDto extends ResponseDto {
//    String serverId;
//    String serverName;
    List<ServerIdResponseDto> row ;

    private OpenServerIdResponseDto(List<ServerIdResponseDto> row){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
//        this.serverId = serverId;
//        this.serverName = serverName;
        this.row = row;
    }
    public static ResponseEntity<ResponseDto> success(List<ServerIdResponseDto> row) {
        OpenServerIdResponseDto result = new OpenServerIdResponseDto(row);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
