package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.data.models.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequest {
    private String Id;
    private String productName;
    private String productCategory;
    private BigDecimal cost;
    private User user;
    private String billingAddress;
    private String paymentMethod;
    private String dispatchOrder;
    private List<Item> items = new ArrayList<>();

}
