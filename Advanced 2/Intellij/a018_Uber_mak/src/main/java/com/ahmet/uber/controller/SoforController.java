package com.ahmet.uber.controller;

import com.ahmet.uber.dto.request.SoforSaveRequestDto;
import com.ahmet.uber.repository.entity.Sofor;
import com.ahmet.uber.service.SoforService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.uber.constants.EndPoints.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SoforController {

    private final SoforService soforService;

    @PostMapping(SAVE)
    public ResponseEntity<Sofor> save(@RequestBody SoforSaveRequestDto dto) {
        return ResponseEntity.ok(soforService.saveDto(dto));
    }

}
