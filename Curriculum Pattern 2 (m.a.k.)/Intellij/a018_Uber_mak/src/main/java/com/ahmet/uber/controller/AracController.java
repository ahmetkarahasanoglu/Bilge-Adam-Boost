package com.ahmet.uber.controller;

import com.ahmet.uber.dto.request.AracSaveRequestDto;
import com.ahmet.uber.repository.entity.Arac;
import com.ahmet.uber.service.AracService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.uber.constants.EndPoints.*;

@RestController
@RequestMapping("/arac")
@RequiredArgsConstructor
public class AracController {

    private final AracService aracService;

    @PostMapping(SAVE)
    public ResponseEntity<Arac> save(@RequestBody AracSaveRequestDto dto) {
        return ResponseEntity.ok(aracService.saveDto(dto));
    }

}
