package com.ahmet.controller;

import com.ahmet.dto.request.SiparisSaveRequestDto;
import com.ahmet.repository.entity.Siparis;
import com.ahmet.service.SiparisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahmet.constants.EndPoints.SAVE;

@RestController
@RequestMapping("/siparis")
@RequiredArgsConstructor
public class SiparisController {

    private final SiparisService siparisService;

    @PostMapping(SAVE)
    public ResponseEntity<Siparis> save(@RequestBody SiparisSaveRequestDto dto) {
        return ResponseEntity.ok(siparisService.saveDto(dto));
    }

}
