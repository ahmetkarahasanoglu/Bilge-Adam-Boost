package com.ahmet.repository.view;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VwUserProfile {
    String username;
    String name;
    String userimg;
}
