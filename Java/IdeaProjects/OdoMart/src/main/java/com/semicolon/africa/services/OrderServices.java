package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.response.CheckOutResponse;

public interface OrderServices {
    public CheckOutResponse createAnOrder(CheckOutRequest checkOutRequest);
}
