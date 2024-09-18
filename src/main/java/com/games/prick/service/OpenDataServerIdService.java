package com.games.prick.service;


import com.games.prick.dto.open.OpenBasicResponseDto;
import com.games.prick.dto.open.OpenSearchResponseDto;
import com.games.prick.dto.open.OpenServerIdResponseDto;
import com.games.prick.dto.request.opendata.BasicRequestDto;
import com.games.prick.dto.request.opendata.SearchRequestDto;
import com.games.prick.dto.request.opendata.ServerIdRequestDto;
import org.springframework.http.ResponseEntity;

public interface OpenDataServerIdService {
    ResponseEntity<? super OpenServerIdResponseDto> serverId(ServerIdRequestDto dto);

    ResponseEntity<? super OpenSearchResponseDto> search(SearchRequestDto dto);

    ResponseEntity<? super OpenBasicResponseDto> basic(BasicRequestDto dto);
}
