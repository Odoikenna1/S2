package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.BillingInformation;
import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.dtos.request.AddToCartRequest;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.request.SetUpBillingInformationRequest;
import com.semicolon.africa.dtos.response.AddToCartResponse;
import com.semicolon.africa.dtos.response.CheckOutResponse;

public interface CustomerServices {
    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest);
    public BillingInformation setupBillingInformation(SetUpBillingInformationRequest setupBillingInformationRequest);
    public ShoppingCart findCartBy(String userId);
    public CheckOutResponse handleOrderRequest(CheckOutRequest checkOutRequest);
}
