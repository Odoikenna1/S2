package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="budget")
public class Budget {
    @Id
    private String id;
    private String userId;
    private String description;
}
