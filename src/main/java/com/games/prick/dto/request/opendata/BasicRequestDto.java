package com.games.prick.dto.request.opendata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicRequestDto {
    @JsonIgnore
    String apikey;

    String characterName;

    String serverId;
    @JsonIgnore
    String characterId;
}