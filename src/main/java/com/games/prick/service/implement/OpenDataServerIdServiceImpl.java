package com.games.prick.service.implement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.prick.dto.object.SearcResult;
import com.games.prick.dto.object.ServerDto;
import com.games.prick.dto.request.opendata.*;
import com.games.prick.dto.response.*;
import com.games.prick.entity.BasicInfo;
import com.games.prick.entity.Search;
import com.games.prick.entity.Server;

import com.games.prick.repository.BasicInfoRepository;
import com.games.prick.repository.SearchRepository;
import com.games.prick.repository.ServerIdRepository;
import com.games.prick.service.OpenDataServerIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenDataServerIdServiceImpl implements OpenDataServerIdService {
    // API URL과 API 키는 환경 변수로 관리
    private final String API_URL = "https://api.neople.co.kr/df/servers";
    private final String API_KEY = "Q08kMP1vfysTkL6kPjK4W5Z8ZQtKMI3K";

    private final ServerIdRepository serverIdRepository;
    private final SearchRepository searchRepository;
    private final BasicInfoRepository basicInFoRepository;

    //서버 불러오기
    @Override
    @Transactional
    public ResponseEntity<? super ServerIdResponseDto> serverId(ServerIdRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출

        List<ServerDto> result = new ArrayList<>();
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


                    Server serversd = new Server(serverId, serverName);
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
        return ServerIdResponseDto.success(result);
    }

    //캐릭터 검색
    @Override
    @Transactional
    public ResponseEntity<? super SearchResponseDto> search(SearchRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출
        String characterName = dto.getCharacterName();
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

        return SearchResponseDto.success(result);
    }

    //기본정보
    @Override
    @Transactional
    public ResponseEntity<? super BasicResponseDto> basic(BasicRequestDto dto) {
        // fetchAndSavePublicData() 메서드를 호출
        String serverId = basicInFoRepository.getServer(dto.getServerName());
//        Search characterId = searchRepository.findByCharacterId(dto.getCharacterName());
        String characterId = basicInFoRepository.getCharacter(dto.getCharacterName(), dto.getServerName());


        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrlWithKey = API_URL + "/" + serverId + "/characters/" + characterId + "?apikey=" + API_KEY;
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
                    , jobGrowId, jobName, jobGrowName, fame, adventureName, guildId, guildName);
            basicInFoRepository.save(basicInfo);  // DB에 저장


            log.info("데이터가 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            log.error("데이터 저장 중 오류 발생", e);
        }

        // 서버 ID에 맞는 응답 생성 로직을 추가해야 함
        // 지금은 임시로 null 리턴
        return BasicResponseDto.success(null, null, null, null, null, null, null, null, null, null, null, null);
    }

    //능력치 정보
    @Override
    @Transactional
    public ResponseEntity<? super StatusResponseDto> status(StatusRequestDto dto) {
        return null;
    }

    //장비
    @Override
    @Transactional
    public ResponseEntity<? super EquipmentResponseDto> equipment(EquipmentRequestDto dto) {
        return null;
    }

    //아바타
    @Override
    @Transactional
    public ResponseEntity<? super AvatarResponseDto> avatar(AvatarRequestDto dto) {
        return null;
    }

    //크리쳐
    @Override
    @Transactional
    public ResponseEntity<? super CreatureResponseDto> creature(CreatureRequestDto dto) {
        return null;
    }

    //휘장
    @Override
    @Transactional
    public ResponseEntity<? super FlagResponseDto> flag(FlagRequestDto dto) {
        return null;
    }

    //탈리스만
    @Override
    @Transactional
    public ResponseEntity<? super TalismanResponseDto> talisman(TalismanRequestDto dto) {
        return null;
    }

    //장비특성
    @Override
    @Transactional
    public ResponseEntity<? super EquipmentTraitResponseDto> equipmentTrait(EquipmentTraitRequestDto dto) {
        return null;
    }

    //버프 장비
    @Override
    @Transactional
    public ResponseEntity<? super BuffEquipmentResponseDto> buffEquipment(BuffEquipmentRequestDto dto) {
        return null;
    }

    //버프 아바타
    @Override
    @Transactional
    public ResponseEntity<? super BuffAvatarResponseDto> buffAvatar(BuffAvatarRequestDto dto) {
        return null;
    }

    //버프크리쳐
    @Override
    @Transactional
    public ResponseEntity<? super BuffCreatureResponseDto> buffCreature(BuffCreatureRequestDto dto) {
        return null;
    }

}
