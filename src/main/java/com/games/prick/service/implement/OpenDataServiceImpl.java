package com.games.prick.service.implement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.prick.dto.open.OpenServerIdResponseDto;
import com.games.prick.dto.request.opendata.ServerIdRequestDto;
import com.games.prick.entity.ServerId;
import com.games.prick.repository.OpenDataRepository;
import com.games.prick.service.OpenDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenDataServiceImpl implements OpenDataService {
    // API URL과 API 키는 환경 변수로 관리
    private final String API_URL = "https://api.neople.co.kr/df/servers";
    private final String API_KEY = "Q08kMP1vfysTkL6kPjK4W5Z8ZQtKMI3K";

    private final OpenDataRepository openDataRepository;

    @Override
    public ResponseEntity<? super OpenServerIdResponseDto> serverId(ServerIdRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출
        String serverId = null;
        String serverName = null;
        fetchAndSavePublicData();

        // 서버 ID에 맞는 응답 생성 로직을 추가해야 함
        // 지금은 임시로 null 리턴
        return OpenServerIdResponseDto.success(null, null);
    }

    // 데이터를 외부 API로부터 가져오고 DB에 저장하는 메서드
    public void fetchAndSavePublicData() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrlWithKey = API_URL + "?apikey=" + API_KEY;
            String response = restTemplate.getForObject(apiUrlWithKey, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode servers = rootNode.path("rows");

            if (servers != null && servers.isArray()) {
                for (int i = 0; i < servers.size(); i++) {
                    JsonNode server = servers.get(i);  // 각 서버 데이터

                    // 각 서버의 ID와 이름 추출
                    String serverId = server.path("serverId").asText();
                    String serverName = server.path("serverName").asText();


                    ServerId serversd = new ServerId(serverId, serverName);
                    openDataRepository.save(serversd);  // DB에 저장
                }
            } else {
                log.warn("서버 데이터가 없거나 형식이 올바르지 않습니다.");
            }

            log.info("데이터가 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            log.error("데이터 저장 중 오류 발생", e);
        }
    }
}
