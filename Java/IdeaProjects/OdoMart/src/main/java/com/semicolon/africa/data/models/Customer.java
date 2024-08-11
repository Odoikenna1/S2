package com.semicolon.africa.data.models;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="customers")
public class Customer extends User{
    private String id;
    private String userName;
    private String billingAddress;
    private String creditCard;
}
