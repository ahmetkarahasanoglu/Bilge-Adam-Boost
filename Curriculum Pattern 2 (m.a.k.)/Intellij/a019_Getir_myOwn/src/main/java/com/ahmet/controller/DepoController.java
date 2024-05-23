package com.ahmet.controller;

import com.ahmet.dto.request.DepoSaveRequestDto;
import com.ahmet.repository.entity.Depo;
import com.ahmet.service.DepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.constants.EndPoints.*;

@RestController
@RequestMapping("/arac")
@RequiredArgsConstructor
public class DepoController {

    private final DepoService depoService;

    @PostMapping(SAVE)
    public ResponseEntity<Depo> save(@RequestBody DepoSaveRequestDto dto) {
        return ResponseEntity.ok(depoService.saveDto(dto));
    }

}
