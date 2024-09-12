package com.games.prick.dto.request.opendata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerIdRequestDto {
     @JsonIgnore String serviceKey;

}
