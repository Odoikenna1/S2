package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="billingInformation")
public class BillingInformation {
    @Id
    private String billingId;
    private String userId;
    private String phoneNumber;
    private String country;
    private String nationality;
    private String zipCode;
    private String billingAddress;
}
