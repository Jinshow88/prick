package com.games.prick.controller.opendata;

import com.games.prick.dto.request.opendata.*;
import com.games.prick.dto.response.*;
import com.games.prick.service.OpenDataServerIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.games.prick.common.swagger.opendata.AvatarSwaggerDescription.AVATAR_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.AvatarSwaggerDescription.AVATAR_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.BasicSwaggerDescription.BASIC_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.BasicSwaggerDescription.BASIC_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.BuffAvatarSwaggerDescription.BUFF_AVATAR_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.BuffAvatarSwaggerDescription.BUFF_AVATAR_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.BuffEquipmentSwaggerDescription.BUFF_EQUIP_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.BuffEquipmentSwaggerDescription.BUFF_EQUIP_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.CreatureSwaggerDescription.CREATURE_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.CreatureSwaggerDescription.CREATURE_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.EquipmentSwaggerDescription.EQUIP_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.EquipmentSwaggerDescription.EQUIP_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.EquipmentTraitSwaggerDescription.EQUIP_TRAIT_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.EquipmentTraitSwaggerDescription.EQUIP_TRAIT_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.FlagSwaggerDescription.FLAG_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.FlagSwaggerDescription.FLAG_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.SearchSwaggerDescription.SEARCH_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.SearchSwaggerDescription.SEARCH_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.ServerIdSwaggerDescription.SERVER_ID_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.ServerIdSwaggerDescription.SERVER_ID_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.StatusSwaggerDescription.STATUS_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.StatusSwaggerDescription.STATUS_RESPONSE_ERROR_CODE;
import static com.games.prick.common.swagger.opendata.TalismanSwaggerDescription.TALISMAN_DESCRIPTION;
import static com.games.prick.common.swagger.opendata.TalismanSwaggerDescription.TALISMAN_RESPONSE_ERROR_CODE;
@RestController
@RequestMapping("api/equip")
@RequiredArgsConstructor
@Tag(name = "장비")
public class EquipController {
    private final OpenDataServerIdService service;


    @GetMapping("/server")
    @Operation(summary = "서버 불러오기", description = SERVER_ID_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = SERVER_ID_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ServerIdResponseDto.class)))
    public ResponseEntity<?super ServerIdResponseDto> getServerId(@ParameterObject @ModelAttribute ServerIdRequestDto dto) {
        return service.serverId(dto);
    }

    @GetMapping("/search")
    @Operation(summary = "캐릭터 검색하기", description = SEARCH_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = SEARCH_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = SearchResponseDto.class)))
    public ResponseEntity<?super SearchResponseDto> getSearch(@ParameterObject @ModelAttribute SearchRequestDto dto) {
        return service.search(dto);
    }

    @GetMapping("/basic")
    @Operation(summary = "기본정보", description = BASIC_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = BASIC_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = BasicResponseDto.class)))
    public ResponseEntity<?super BasicResponseDto> getBasic(@ParameterObject @ModelAttribute BasicRequestDto dto) {
        return service.basic(dto);
    }

    @GetMapping("/status")
    @Operation(summary = "능력치 정보", description = STATUS_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = STATUS_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = StatusResponseDto.class)))
    public ResponseEntity<?super StatusResponseDto> getsStatus(@ParameterObject @ModelAttribute StatusRequestDto dto) {
        return service.status(dto);
    }

    @GetMapping("/Equipment")
    @Operation(summary = "장비", description = EQUIP_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = EQUIP_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = EquipmentResponseDto.class)))
    public ResponseEntity<?super EquipmentResponseDto> getEquipment(@ParameterObject @ModelAttribute EquipmentRequestDto dto) {
        return service.equipment(dto);
    }

    @GetMapping("/Avatar")
    @Operation(summary = "아바타", description = AVATAR_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = AVATAR_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = AvatarResponseDto.class)))
    public ResponseEntity<?super AvatarResponseDto> getAvatar(@ParameterObject @ModelAttribute AvatarRequestDto dto) {
        return service.avatar(dto);
    }

    @GetMapping("/Creature")
    @Operation(summary = "크리쳐", description = CREATURE_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = CREATURE_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = CreatureResponseDto.class)))
    public ResponseEntity<?super CreatureResponseDto> getCreature(@ParameterObject @ModelAttribute CreatureRequestDto dto) {
        return service.creature(dto);
    }

    @GetMapping("/Flag")
    @Operation(summary = "휘장", description = FLAG_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = FLAG_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = FlagResponseDto.class)))
    public ResponseEntity<?super FlagResponseDto> getFlag(@ParameterObject @ModelAttribute FlagRequestDto dto) {
        return service.flag(dto);
    }

    @GetMapping("/talisman")
    @Operation(summary = "탈리스만", description = TALISMAN_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = TALISMAN_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = TalismanResponseDto.class)))
    public ResponseEntity<?super TalismanResponseDto> getTalisman(@ParameterObject @ModelAttribute TalismanRequestDto dto) {
        return service.talisman(dto);
    }

    @GetMapping("/equipmentTrait")
    @Operation(summary = "장비특성", description = EQUIP_TRAIT_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = EQUIP_TRAIT_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = EquipmentTraitResponseDto.class)))
    public ResponseEntity<?super EquipmentTraitResponseDto> getEquipmentTrait(@ParameterObject @ModelAttribute EquipmentTraitRequestDto dto) {
        return service.equipmentTrait(dto);
    }

    @GetMapping("/buffEquipment")
    @Operation(summary = "버프 장비", description = BUFF_EQUIP_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = BUFF_EQUIP_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = BuffEquipmentResponseDto.class)))
    public ResponseEntity<?super BuffEquipmentResponseDto> getBuffEquipment(@ParameterObject @ModelAttribute BuffEquipmentRequestDto dto) {
        return service.buffEquipment(dto);
    }

    @GetMapping("/buffAvatar")
    @Operation(summary = "버프 아바타", description = BUFF_AVATAR_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = BUFF_AVATAR_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = BuffAvatarResponseDto.class)))
    public ResponseEntity<?super BuffAvatarResponseDto> getBuffAvatar(@ParameterObject @ModelAttribute BuffAvatarRequestDto dto) {
        return service.buffAvatar(dto);
    }

    @GetMapping("/buffCreature")
    @Operation(summary = "버프크리쳐", description = BUFF_AVATAR_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = BUFF_AVATAR_RESPONSE_ERROR_CODE,
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = BuffCreatureResponseDto.class)))
    public ResponseEntity<?super BuffCreatureResponseDto> getBuffCreature(@ParameterObject @ModelAttribute BuffCreatureRequestDto dto) {
        return service.buffCreature(dto);
    }
}































