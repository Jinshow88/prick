package com.games.prick.service;


import com.games.prick.dto.open.OpenServerIdResponseDto;
import com.games.prick.dto.request.opendata.ServerIdRequestDto;
import org.springframework.http.ResponseEntity;

public interface OpenDataService {
    ResponseEntity<? super OpenServerIdResponseDto> serverId(ServerIdRequestDto dto);
}
