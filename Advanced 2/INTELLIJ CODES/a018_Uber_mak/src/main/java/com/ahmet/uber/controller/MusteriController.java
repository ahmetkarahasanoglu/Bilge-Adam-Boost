package com.ahmet.uber.controller;

import com.ahmet.uber.dto.request.MusteriSaveRequestDto;
import com.ahmet.uber.repository.entity.Musteri;
import com.ahmet.uber.service.MusteriService;
import static com.ahmet.uber.constants.EndPoints.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.uber.constants.EndPoints.SAVE;

@RestController
@RequestMapping("/musteri")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;


    @PostMapping(SAVE)
    public ResponseEntity<Musteri> save(@RequestBody @Valid MusteriSaveRequestDto dto) {
    Musteri musteri = musteriService.saveDto(dto);
    return ResponseEntity.ok(musteri);
    }

}
