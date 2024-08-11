package com.semicolon.africa.data.dtos.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreatedPostRequest {
    private String title;
    private String content;
}
