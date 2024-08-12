package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.data.domain.OrderStatus;
import com.semicolon.africa.data.repositories.OrderRepository;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.response.CheckOutResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class OrderServicesImpl implements OrderServices{

    private final OrderRepository orderRepo;
    @Override
    public CheckOutResponse createAnOrder(@NotNull CheckOutRequest checkOutRequest) {
        Order order = new Order();
        order.setId(checkOutRequest.getId());
        order.setUserId(checkOutRequest.getUserId());
        order.setSubTotal(checkOutRequest.getSubTotal());
        order.setBillingAddress(checkOutRequest.getBillingAddress());
        order.setPaymentMethod(checkOutRequest.getPaymentMethod());
        order.setItems(checkOutRequest.getItems());
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepo.save(order);
        CheckOutResponse checkOutResponse = new CheckOutResponse();
        checkOutResponse.setId(savedOrder.getId());
        checkOutResponse.setOrderCreationDate(savedOrder.getOrderCreationDate());
        checkOutResponse.setStatus(savedOrder.getStatus());
        checkOutResponse.setSubTotal(savedOrder.getSubTotal());
        checkOutResponse.setItems(savedOrder.getItems());
        checkOutResponse.setBillingAddress(savedOrder.getBillingAddress());
        checkOutResponse.setPaymentMethod(savedOrder.getPaymentMethod());
        return checkOutResponse;
    }
}
