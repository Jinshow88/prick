package com.games.prick.service;


import com.games.prick.dto.request.opendata.*;
import com.games.prick.dto.response.*;
import org.springframework.http.ResponseEntity;

public interface OpenDataServerIdService {
    ResponseEntity<? super ServerIdResponseDto> serverId(ServerIdRequestDto dto);

    ResponseEntity<? super SearchResponseDto> search(SearchRequestDto dto);

    ResponseEntity<? super BasicResponseDto> basic(BasicRequestDto dto);

    ResponseEntity<? super StatusResponseDto> status(StatusRequestDto dto);

    ResponseEntity<? super EquipmentResponseDto> equipment(EquipmentRequestDto dto);

    ResponseEntity<? super AvatarResponseDto> avatar(AvatarRequestDto dto);

    ResponseEntity<? super CreatureResponseDto> creature(CreatureRequestDto dto);

    ResponseEntity<? super FlagResponseDto> flag(FlagRequestDto dto);

    ResponseEntity<? super TalismanResponseDto> talisman(TalismanRequestDto dto);

    ResponseEntity<? super EquipmentTraitResponseDto> equipmentTrait(EquipmentTraitRequestDto dto);

    ResponseEntity<? super BuffEquipmentResponseDto> buffEquipment(BuffEquipmentRequestDto dto);

    ResponseEntity<? super BuffAvatarResponseDto> buffAvatar(BuffAvatarRequestDto dto);

    ResponseEntity<? super BuffCreatureResponseDto> buffCreature(BuffCreatureRequestDto dto);
}
