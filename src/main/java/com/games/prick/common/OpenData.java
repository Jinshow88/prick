package com.games.prick.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.prick.dto.object.SearcResult;
import com.games.prick.dto.response.SearchResponseDto;
import com.games.prick.entity.Search;
import com.games.prick.repository.SearchRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@Getter
public class OpenData {
    private final String API_URL;
    private final String API_KEY;
    private final String characterName;
    public final String openDate;

    public OpenData(DTO dto, @Value("${api.url}") String apiUrl, @Value("${open.key}") String apiKey, @Value("${file.directory}") String openDate) {
        this.API_URL = apiUrl;
        this.API_KEY = apiKey;
        this.characterName = dto.getCharacterName();
        this.openDate = openDate;
    }
    public void publicDate() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrlWithKey = API_URL + "/all/characters?characterName=" + characterName + "&apikey=" + API_KEY;
            String respons = restTemplate.getForObject(apiUrlWithKey, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(respons);
            JsonNode servers = rootNode.path("rows");

            if (servers != null && servers.isArray()) {
                for (int i = 0; i < servers.size(); i++) {
                    JsonNode server = servers.get(i);  // 각 서버 데이터

                    // 각 서버의 ID와 이름 추출
                    String serverId = server.path("serverId").asText();
                    String characterId = server.path("characterId").asText();
//                    String characterName = server.path("characterName").asText();
                    String level = server.path("level").asText();
                    String jobId = server.path("jobId").asText();
                    String jobGrowId = server.path("jobGrowId").asText();
                    String jobName = server.path("jobName").asText();
                    String jobGrowName = server.path("jobGrowName").asText();
                    String fame = server.path("fame").asText();


                    Search search = new Search(serverId, characterId, characterName, level, jobId
                            , jobGrowId, jobName, jobGrowName, fame);
                    searchRepository.save(search);  // DB에 저장
                }
            } else {
                log.warn("서버 데이터가 없거나 형식이 올바르지 않습니다.");
            }

            log.info("데이터가 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            log.error("데이터 저장 중 오류 발생", e);
        }
        SearcResult result = new SearcResult();
        result.setServerId(result.getServerId());
        result.setCharacterId(result.getCharacterId());
        result.setLevel(result.getLevel());
        result.setJobId(result.getJobId());
        result.setJobGrowId(result.getJobGrowId());
        result.setJobName(result.getJobName());
        result.setJobGrowName(result.getJobGrowName());
        result.setFame(result.getFame());
        // 서버 ID에 맞는 응답 생성 로직을 추가해야 함
        // 지금은 임시로 null 리턴

    }

}
