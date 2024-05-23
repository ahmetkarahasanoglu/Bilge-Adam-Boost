package com.ahmet.controller;

import com.ahmet.dto.request.NewCreateUserRequestDto;
import com.ahmet.dto.request.UserProfileUpdateRequestDto;
import com.ahmet.repository.entity.UserProfile;
import com.ahmet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmet.constants.EndPoints.*;

/**
 * findbyusername metodu yazalım. Bu metodu servis'te cache'leyelim.
 */

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto) { // AuthMicroService'in buraya gönderdiği veriyi yakalayacak burası.
        return ResponseEntity.ok(userProfileService.createUser(dto));
    }

    @GetMapping(ACTIVATESTATUS+"/{authId}") // path variable kullandık.
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId) {
        return ResponseEntity.ok(userProfileService.activateStatus(authId));
    }

    @PutMapping(UPDATE) // '@PutMapping': Güncellemeye özel (update'e özel) bir kullanımdır; PostMapping'le çok bi farkı yok (PostMapping de kullansak bi sıkıntı çıkmaz). - ('@PutMapping': update,  '@PostMapping': create new resources)
    public ResponseEntity<Boolean> update(@RequestBody UserProfileUpdateRequestDto dto) {
        return ResponseEntity.ok(userProfileService.update(dto));
    }

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> delete(@RequestParam Long authId) {
        return ResponseEntity.ok(userProfileService.delete(authId));
    }

    @GetMapping(FINDALL)
    @PreAuthorize("hasAuthority('USER')") // bu metoda sadece 'USER' yetkisi olan kişiler ulaşabilir.
    public ResponseEntity<List<UserProfile>> findAll() {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/findbyusername")
    public ResponseEntity<UserProfile> findbyusername(@RequestParam String username) {
        return ResponseEntity.ok(userProfileService.findByUsername(username));
    }

    @GetMapping("/findbyrole")
    public ResponseEntity<List<UserProfile>> findByRole(@RequestParam String role) {
        return ResponseEntity.ok(userProfileService.findByRole(role));
    }



}
