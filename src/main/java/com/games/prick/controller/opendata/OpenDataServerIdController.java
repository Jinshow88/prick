package com.games.prick.controller.opendata;

import com.games.prick.dto.open.OpenBasicResponseDto;
import com.games.prick.dto.open.OpenSearchResponseDto;
import com.games.prick.dto.open.OpenServerIdResponseDto;
import com.games.prick.dto.request.opendata.BasicRequestDto;
import com.games.prick.dto.request.opendata.SearchRequestDto;
import com.games.prick.dto.request.opendata.ServerIdRequestDto;
import com.games.prick.service.OpenDataServerIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.games.prick.common.swagger.opendata.ServerIdSwaggerDescription.USER_BOOK_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.ServerIdSwaggerDescription.USER_BOOK_RESPONSE_ERROR_CODE;

@RestController
@RequestMapping("api/open")
@RequiredArgsConstructor
@Tag(name = "오픈 데이터")
public class OpenDataServerIdController {
    private final OpenDataServerIdService service;


    @GetMapping("/server")
    @Operation(summary = "서버 불러오기", description = USER_BOOK_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = USER_BOOK_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = OpenServerIdResponseDto.class)))
    public ResponseEntity<?super OpenServerIdResponseDto> getServerId(@ParameterObject @ModelAttribute ServerIdRequestDto dto) {
        return service.serverId(dto);
    }

    @GetMapping("/search")
    @Operation(summary = "캐릭터 검색하기", description = USER_BOOK_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = USER_BOOK_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = OpenSearchResponseDto.class)))
    public ResponseEntity<?super OpenSearchResponseDto> getSearch(@ParameterObject @ModelAttribute SearchRequestDto dto) {
        return service.search(dto);
    }

    @GetMapping("/basic")
    @Operation(summary = "기본정보", description = USER_BOOK_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = USER_BOOK_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = OpenBasicResponseDto.class)))
    public ResponseEntity<?super OpenBasicResponseDto> getBasic(@ParameterObject @ModelAttribute BasicRequestDto dto) {
        return service.basic(dto);
    }
}































