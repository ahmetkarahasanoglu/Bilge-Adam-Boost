package com.ahmet.Monolitik.exception;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ErrorMessage {

    int code;
    String message;
    List<String> fields;

}
