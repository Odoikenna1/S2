package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.dtos.request.IncreaseItemQuantityRequest;
import com.semicolon.africa.dtos.request.InitializeItemRequest;
import com.semicolon.africa.dtos.request.ReduceItemQuantityRequest;
import org.springframework.stereotype.Service;


public interface ItemServices {
    public Item initializeItem(InitializeItemRequest initializeItemRequest);
}
