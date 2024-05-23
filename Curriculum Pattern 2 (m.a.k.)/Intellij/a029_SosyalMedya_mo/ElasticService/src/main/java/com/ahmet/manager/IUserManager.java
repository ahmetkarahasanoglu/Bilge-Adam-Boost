package com.ahmet.manager;

import com.ahmet.repository.entity.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.ahmet.constants.EndPoints.FINDALL;

@FeignClient(url = "http://localhost:7072/api/v1/user", decode404 = true, name = "elastic-userprofile") // UserMikroServis'in url'si (port 7072) -  '/user:' UserProfileController
public interface IUserManager {


    @GetMapping(FINDALL)
    public ResponseEntity<List<UserProfile>> findAll();
}
