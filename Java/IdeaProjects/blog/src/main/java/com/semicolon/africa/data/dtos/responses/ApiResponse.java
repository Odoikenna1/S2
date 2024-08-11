package com.semicolon.africa.data.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;


@Data @AllArgsConstructor @NoArgsConstructor public class
ApiResponse <T>{
    private T message;
    private boolean isSuccessful;
}
