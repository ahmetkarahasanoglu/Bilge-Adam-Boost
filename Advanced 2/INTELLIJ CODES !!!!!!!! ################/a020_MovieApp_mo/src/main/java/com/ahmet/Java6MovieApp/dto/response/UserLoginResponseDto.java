package com.ahmet.Java6MovieApp.dto.response;

import com.ahmet.Java6MovieApp.repository.entity.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private EUserType userType;
//    private List<Long> favGenres;
//    private List<Long> favMovies;
//    private List<Long> comments;

}
