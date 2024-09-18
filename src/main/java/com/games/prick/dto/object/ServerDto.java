package com.games.prick.dto.object;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServerDto {

    @Schema(example = "뉴욕 카라반", description = "글램핑장의 이름")
    private String serverId;
    @Schema(example = "경북", description = "글램핑장의 위치")
    private String serverName;

}