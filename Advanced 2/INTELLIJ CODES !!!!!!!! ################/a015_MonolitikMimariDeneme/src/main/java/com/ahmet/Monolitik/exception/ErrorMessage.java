package com.ahmet.Monolitik.exception;

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
