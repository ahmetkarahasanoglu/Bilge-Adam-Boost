package com.ahmet.controller;

import com.ahmet.dto.request.UrunSaveRequestDto;
import com.ahmet.repository.entity.Urun;
import com.ahmet.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.constants.EndPoints.*;

@RestController
@RequestMapping("/urun")
@RequiredArgsConstructor
public class UrunController {

    private final UrunService urunService;

    @PostMapping(SAVE)
    public ResponseEntity<Urun> save(@RequestBody UrunSaveRequestDto dto) {
        return ResponseEntity.ok(urunService.saveDto(dto));
    }

}
