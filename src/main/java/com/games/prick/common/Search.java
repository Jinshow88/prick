package com.games.prick.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.prick.repository.BasicInForRepository;
import com.games.prick.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Search {

    private final WebClient webClient = WebClient.builder().baseUrl("https://api.neople.co.kr/df/servers/<serverId>/characters?characterName=<characterName>&jobId=<jobId>&jobGrowId=<jobGrowId>&isAllJobGrow=<isAllJobGrow>&limit=<limit>&wordType=<wordType>&apikey=Q08kMP1vfysTkL6kPjK4W5Z8ZQtKMI3K").build();
    private final SearchRepository searchRepository;  // JPA 리포지토리를 주입받음

    @Value("${open-data.service-key}")
    private String serviceKey;

    private Integer page = 1;

    public void getOpenData() {
        while (true) {
            Mono<Map<String, Object>> mono = webClient
                    .get()
                    .uri("openapi/service/rest/PlantService/plntIlstrSearch" +
                            "?serviceKey=" + serviceKey +
                            "&st=1" +
                            "&numOfRows=300" +
                            "&pageNo=" + page +
                            "&_type=json"
                    )
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});

            try {
                Map<String, Object> info = mono.block();
                ObjectMapper objectMapper = new ObjectMapper();
                String elem = objectMapper.writeValueAsString(info);
                JsonNode rootNode = objectMapper.readTree(elem);
                JsonNode itemsNode = rootNode.path("response").path("body").path("items").path("item");

                List<PlantData> list = objectMapper.convertValue(
                        itemsNode, objectMapper.getTypeFactory().constructCollectionType(List.class, PlantData.class));

                if (list == null || list.isEmpty()) {
                    break;
                }

                // 가져온 데이터를 데이터베이스에 저장
                searchRepository.saveAll(list);  // JPA 리포지토리를 사용하여 리스트를 저장
                page++;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void deleteAllPlantData() {
        searchRepository.deleteAll();  // 모든 데이터를 삭제
    }
}