package com.ahmet.Monolitik.controller;

import com.ahmet.Monolitik.dto.request.DoLoginRequestDto;
import com.ahmet.Monolitik.dto.request.UserSaveRequestDto;
import com.ahmet.Monolitik.dto.response.DoLoginResponseDto;
import com.ahmet.Monolitik.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    @CrossOrigin("*")
    public void save(@RequestBody UserSaveRequestDto dto) {
        userService.save(dto.getUsername(), dto.getEmail(), dto.getPassword());
    }

    @PostMapping("/dologin")
    @CrossOrigin("*")
    public ResponseEntity<DoLoginResponseDto> dologin(@RequestBody DoLoginRequestDto dto) {
        boolean isLogin = userService.isUser(dto.getEmail(), dto.getPassword());
        if(isLogin) {
            return ResponseEntity.ok(DoLoginResponseDto.builder().token("this_is_token").build());
        }
        return ResponseEntity.badRequest().build();
    }
}
