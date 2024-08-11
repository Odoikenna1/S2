package com.semicolon.africa.data.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public enum Role {
    ADMIN, VENDOR, CUSTOMER;
}
