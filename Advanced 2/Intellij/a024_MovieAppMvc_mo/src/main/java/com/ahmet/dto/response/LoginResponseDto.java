package com.ahmet.dto.response;

import com.ahmet.repository.entity.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

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
