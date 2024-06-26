package com.ahmet.manager;

import com.ahmet.dto.request.UpdateEmailOrUsernameRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmet.constants.EndPoints.FINDBYROLE;

@FeignClient(url = "http://localhost:7071/api/v1/auth", decode404 = true, name = "userprofile-auth")
public interface IAuthManager {

    @PutMapping("/updateemailorusername")
    public ResponseEntity<Boolean> updateEmailOrUsername(@RequestBody UpdateEmailOrUsernameRequestDto dto);

    @GetMapping(FINDBYROLE)
    public ResponseEntity<List<Long>> findByRole(@RequestParam String role);
}
