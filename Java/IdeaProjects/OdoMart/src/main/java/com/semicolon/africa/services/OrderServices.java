package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.dtos.request.CheckOutRequest;

public interface OrderServices {
    public Order createAnOrder(CheckOutRequest checkOutRequest);
}
