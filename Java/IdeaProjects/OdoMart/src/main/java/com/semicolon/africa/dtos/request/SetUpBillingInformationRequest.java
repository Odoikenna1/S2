package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetUpBillingInformationRequest {
    private String userId;
    private String phoneNumber;
    private String country;
    private String nationality;
    private String zipCode;
    private String billingAddress;
}
