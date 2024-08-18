package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.dtos.request.IncreaseItemQuantityRequest;
import com.semicolon.africa.dtos.request.InitializeItemRequest;
import com.semicolon.africa.dtos.request.ReduceItemQuantityRequest;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ItemServicesImpl implements ItemServices {

    private CartServices cartServices;

    @Autowired
    @Lazy
    public void setCartServices(CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @Override
    public Item initializeItem(@NotNull InitializeItemRequest initializeItemRequest) {
        Item item = new Item();
        item.setPrice(initializeItemRequest.getPrice());
        item.setProduct(initializeItemRequest.getProduct());
        item.setCartId(initializeItemRequest.getCartId());
        item.setQuantity(initializeItemRequest.getQuantity());
        return item;
    }

}
