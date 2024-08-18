package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.request.FindSubTotalRequest;
import com.semicolon.africa.dtos.response.CheckOutResponse;
import com.semicolon.africa.dtos.response.PaymentProcessResponse;

public interface OrderServices {
    public CheckOutResponse createAnOrder(CheckOutRequest checkOutRequest);
    public Order findOrderBy(String userId);
    public Order updateOrderStatus(PaymentProcessResponse paymentProcessResponse);
}
