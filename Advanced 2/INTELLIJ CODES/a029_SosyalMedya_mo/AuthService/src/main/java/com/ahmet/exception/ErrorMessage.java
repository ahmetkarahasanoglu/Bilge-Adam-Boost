package com.ahmet.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ErrorMessage {

    private int code;
    private String message;
    private List<String> fields;
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

}
