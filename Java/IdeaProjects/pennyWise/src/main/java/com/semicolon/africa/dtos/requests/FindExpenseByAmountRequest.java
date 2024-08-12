package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class FindExpenseByAmountRequest {
    private String dateTime;
}
