package com.games.prick.controller.opendata;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/json")
@RequiredArgsConstructor
@Tag(name = "JSON 형태 변환 컨트롤러 - FE 사용 X")
public class OpenDataServerIdController {
}
