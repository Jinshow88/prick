package com.games.prick.service.implement;

import com.games.prick.common.OpenDataServerId;
import com.games.prick.dto.object.GetServer;
import com.games.prick.dto.open.OpenServerIdResponseDto;
import com.games.prick.dto.request.opendata.ServerIdRequestDto;
import com.games.prick.dto.response.ServerIdResponseDto;
import com.games.prick.service.OpenDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenDataServiceImpl implements OpenDataService {
    private OpenDataServerId openDataServerId;
    @Value("${open-data.service-key}")
    private String apikey;

    @Override
    public ResponseEntity<? super OpenServerIdResponseDto> serverId(ServerIdRequestDto dto) {
        dto.setServiceKey(apikey);

        String serverId = null;
        String serverName = null;
        List<ServerIdResponseDto> row = new ArrayList<>();

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.neople.co.kr")
                .build();

        String apiUrl = "/df/servers?apikey={apikey}";
        OpenServerIdResponseDto weatherResponse = webClient.get()
                .uri(apiUrl, apikey)
                .retrieve()
                .bodyToMono(OpenServerIdResponseDto.class)
                .block();

        return  OpenServerIdResponseDto.success(row);
    }
}
