package com.ahmet.controller;

import com.ahmet.dto.request.UserProfileSaveRequestDto;
import com.ahmet.repository.entity.UserProfile;
import com.ahmet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmet.constants.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto) {
        return ResponseEntity.ok(userProfileService.saveDto(dto));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<UserProfile>> findAll() {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/getname")
    public ResponseEntity<String> getUpperName(String name) {
        return ResponseEntity.ok(userProfileService.getUpper(name));
    }

    @GetMapping("/clearcache")
    public ResponseEntity<Void> clearCache() {
        userProfileService.clearCache();
        return ResponseEntity.ok().build();
    }

}
