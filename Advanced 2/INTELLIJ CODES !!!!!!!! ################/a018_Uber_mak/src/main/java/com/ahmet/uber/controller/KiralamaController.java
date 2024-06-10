package com.ahmet.uber.controller;

import com.ahmet.uber.dto.request.KiralamaSaveRequestDto;
import com.ahmet.uber.repository.entity.Kiralama;
import com.ahmet.uber.service.KiralamaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.uber.constants.EndPoints.*;

@RestController
@RequestMapping("/kiralama")
@RequiredArgsConstructor
public class KiralamaController {

    private final KiralamaService kiralamaService;

    @PostMapping(SAVE)
    public ResponseEntity<Kiralama> save(@RequestBody @Valid KiralamaSaveRequestDto dto) {
        return ResponseEntity.ok(kiralamaService.saveDto(dto));
    }
}
