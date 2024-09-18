package com.games.prick.service.implement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.prick.dto.open.OpenBasicResponseDto;
import com.games.prick.dto.open.OpenSearchResponseDto;
import com.games.prick.dto.open.OpenServerIdResponseDto;
import com.games.prick.dto.request.opendata.BasicRequestDto;
import com.games.prick.dto.request.opendata.SearchRequestDto;
import com.games.prick.dto.request.opendata.ServerIdRequestDto;
import com.games.prick.entity.BasicInfo;
import com.games.prick.entity.Search;
import com.games.prick.entity.ServerId;

import com.games.prick.repository.BasicInForRepository;
import com.games.prick.repository.SearchRepository;
import com.games.prick.repository.ServerIdRepository;
import com.games.prick.service.OpenDataServerIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenDataServerIdServiceImpl implements OpenDataServerIdService {
    // API URL과 API 키는 환경 변수로 관리
    private final String API_URL = "https://api.neople.co.kr/df/servers";
    private final String API_KEY = "Q08kMP1vfysTkL6kPjK4W5Z8ZQtKMI3K";

    private final ServerIdRepository serverIdRepository;
    private final SearchRepository searchRepository;
    private final BasicInForRepository basicInFoRepository;

    @Override
    public ResponseEntity<? super OpenServerIdResponseDto> serverId(ServerIdRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출

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
                    serverIdRepository.save(serversd);  // DB에 저장
                }
            } else {
                log.warn("서버 데이터가 없거나 형식이 올바르지 않습니다.");
            }

            log.info("데이터가 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            log.error("데이터 저장 중 오류 발생", e);
        }

        // 서버 ID에 맞는 응답 생성 로직을 추가해야 함
        // 지금은 임시로 null 리턴
        return OpenServerIdResponseDto.success(null, null);
    }
    @Override
    public ResponseEntity<? super OpenSearchResponseDto> search(SearchRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출

        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrlWithKey = API_URL + "/all/characters?characterName=운빵이&apikey=" + API_KEY;
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
                    String characterName = server.path("characterName").asText();
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

        // 서버 ID에 맞는 응답 생성 로직을 추가해야 함
        // 지금은 임시로 null 리턴
        return OpenSearchResponseDto.success(null, null, null, null, null, null, null, null, null);
    }
    @Override
    public ResponseEntity<? super OpenBasicResponseDto> basic(BasicRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출
        String serverId = dto.getServerId();
        Search characterId = searchRepository.findByCharacterId(dto.getCharacterName());


//        String characterId = dto.getCharacterName();

        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrlWithKey = API_URL + "/"+serverId+"/characters/"+characterId+"?apikey=" + API_KEY;
            String respons = restTemplate.getForObject(apiUrlWithKey, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(respons);


                    // 각 서버의 ID와 이름 추출
//                    String serverId = rootNode.path("serverId").asText();
//                    String characterId = rootNode.path("characterId").asText();
                    String characterName = rootNode.path("characterName").asText();
                    String level = rootNode.path("level").asText();
                    String jobId = rootNode.path("jobId").asText();
                    String jobGrowId = rootNode.path("jobGrowId").asText();
                    String jobName = rootNode.path("jobName").asText();
                    String jobGrowName = rootNode.path("jobGrowName").asText();
                    String fame = rootNode.path("fame").asText();
                    String adventureName = rootNode.path("adventureName").asText();
                    String guildId = rootNode.path("guildId").asText();
                    String guildName = rootNode.path("guildName").asText();


                    BasicInfo basicInfo = new BasicInfo(serverId, characterId, characterName, level, jobId
                            , jobGrowId, jobName, jobGrowName, fame,adventureName,guildId,guildName);
                    basicInFoRepository.save(basicInfo);  // DB에 저장





            log.info("데이터가 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            log.error("데이터 저장 중 오류 발생", e);
        }

        // 서버 ID에 맞는 응답 생성 로직을 추가해야 함
        // 지금은 임시로 null 리턴
        return OpenBasicResponseDto.success(null, null, null, null, null, null, null, null, null,null,null,null);
    }
    // 데이터를 외부 API로부터 가져오고 DB에 저장하는 메서드
//    @Transactional
//    public void fetchAndSavePublicData() {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String apiUrlWithKey = API_URL + "?apikey=" + API_KEY;
//            String response = restTemplate.getForObject(apiUrlWithKey, String.class);
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode rootNode = objectMapper.readTree(response);
//            JsonNode servers = rootNode.path("rows");
//
//            if (servers != null && servers.isArray()) {
//                for (int i = 0; i < servers.size(); i++) {
//                    JsonNode server = servers.get(i);  // 각 서버 데이터
//
//                    // 각 서버의 ID와 이름 추출
//                    String serverId = server.path("serverId").asText();
//                    String serverName = server.path("serverName").asText();
//
//
//                    ServerId serversd = new ServerId(serverId, serverName);
//                    serverIdRepository.save(serversd);  // DB에 저장
//                }
//            } else {
//                log.warn("서버 데이터가 없거나 형식이 올바르지 않습니다.");
//            }
//
//            log.info("데이터가 성공적으로 저장되었습니다.");
//        } catch (Exception e) {
//            log.error("데이터 저장 중 오류 발생", e);
//        }
//    }
}
