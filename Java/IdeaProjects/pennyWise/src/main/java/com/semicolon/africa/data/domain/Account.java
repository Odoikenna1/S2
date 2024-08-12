package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "account")
public class Account {
    @Id
    private int accountId;
    private String userId;
    private Currency currency;
}
