package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.BillingInformation;
import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.data.repositories.BillingInformationRepository;
import com.semicolon.africa.dtos.request.AddToCartRequest;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.request.SetUpBillingInformationRequest;
import com.semicolon.africa.dtos.response.AddToCartResponse;
import com.semicolon.africa.dtos.response.CheckOutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class CustomerServicesImpl implements CustomerServices{

    private final BillingInformationRepository billingInformationRepository;
    private final CartServices cartServices;
    private final OrderServices orderServices;


    @Override
    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest) {
        return cartServices.addToCart(addToCartRequest);
    }

    @Override
    public BillingInformation setupBillingInformation(SetUpBillingInformationRequest setupBillingInformationRequest) {
        BillingInformation billingInformation = new BillingInformation();
        billingInformation.setBillingAddress(setupBillingInformationRequest.getBillingAddress());
        billingInformation.setCountry(setupBillingInformationRequest.getCountry());
        billingInformation.setNationality(setupBillingInformationRequest.getNationality());
        billingInformation.setPhoneNumber(setupBillingInformationRequest.getPhoneNumber());
        billingInformation.setUserId(setupBillingInformationRequest.getUserId());
        billingInformation.setZipCode(setupBillingInformationRequest.getZipCode());
        BillingInformation savedBillingInfo = billingInformationRepository.save(billingInformation);
        return savedBillingInfo;
    }

    @Override
    public ShoppingCart findCartBy(String userId) {
        return cartServices.findCartByUserId(userId);
    }

    @Override
    public CheckOutResponse handleOrderRequest(CheckOutRequest checkOutRequest) {
        BillingInformation savedBillingInformation = setupBillingInformation(checkOutRequest.getSetupBillingInformationRequest());
        //checkOutRequest.setBillingInformation();
        CheckOutResponse checkOutResponse=  orderServices.createAnOrder(checkOutRequest);
        return checkOutResponse;
    }
}
