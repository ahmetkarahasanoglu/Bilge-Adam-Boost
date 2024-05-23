package com.ahmet.controller;

import com.ahmet.dto.request.KuryeSaveRequestDto;
import com.ahmet.repository.entity.Kurye;
import com.ahmet.service.KuryeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.ahmet.constants.EndPoints.*;

@RestController
@RequestMapping("/kurye")
@RequiredArgsConstructor
public class KuryeController {

    private final KuryeService kuryeService;

    @PostMapping(SAVE)
        public ResponseEntity<Kurye> save(@RequestBody KuryeSaveRequestDto dto) {
            return ResponseEntity.ok(kuryeService.saveDto(dto));
        }

}
