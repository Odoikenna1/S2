package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.*;
import com.semicolon.africa.data.domain.PaymentMethod;
import lombok.Data;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CheckOutRequest {
    private String userId;
    private SetUpBillingInformationRequest setupBillingInformationRequest;
//    private BillingInformation billingInformation;
    private ShoppingCart cart;
    private String shippingAddress;
    private String billingAddress;
    private PaymentMethod paymentMethod;
    private List<Item> items = new ArrayList<>();
    private OrderStatus status;
}
