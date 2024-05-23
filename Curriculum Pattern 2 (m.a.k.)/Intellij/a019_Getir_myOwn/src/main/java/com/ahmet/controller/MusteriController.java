package com.ahmet.controller;

import com.ahmet.dto.request.MusteriSaveRequestDto;
import com.ahmet.repository.entity.Musteri;
import com.ahmet.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.ahmet.constants.EndPoints.*;

@RestController
@RequestMapping("/musteri")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;

    @PostMapping(SAVE)
    public ResponseEntity<Musteri> save(@RequestBody MusteriSaveRequestDto dto) {
        return ResponseEntity.ok(musteriService.saveDto(dto));
    }

}
