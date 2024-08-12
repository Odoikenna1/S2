package com.semicolon.africa.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection="user")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String occupation;
    private String address;
    private long monthlyEarning;

}
