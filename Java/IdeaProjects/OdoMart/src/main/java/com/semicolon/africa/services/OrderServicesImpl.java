package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.data.domain.OrderStatus;
import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.data.repositories.OrderRepository;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.request.FindSubTotalRequest;
import com.semicolon.africa.dtos.response.CheckOutResponse;
import com.semicolon.africa.dtos.response.PaymentProcessResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service @RequiredArgsConstructor
public class OrderServicesImpl implements OrderServices{


    private final CartServices cartServices;

    private final OrderRepository orderRepo;

    @Override
    public CheckOutResponse createAnOrder(@NotNull CheckOutRequest checkOutRequest) {
        Order order = new Order();
//        checkOutRequest.get
        ShoppingCart shoppingCart = cartServices.findCartByUserId(checkOutRequest.getUserId());

        checkOutRequest.getUserId();
        order.setUserId(checkOutRequest.getUserId());
        order.setSubTotal(shoppingCart.getSubTotal());
        order.setBillingAddress(checkOutRequest.getBillingAddress());
        order.setShippingAddress(checkOutRequest.getShippingAddress());
        order.setPaymentMethod(checkOutRequest.getPaymentMethod());
        order.setItems(checkOutRequest.getItems());
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepo.save(order);


        CheckOutResponse checkOutResponse = new CheckOutResponse();
        checkOutResponse.setId(savedOrder.getId());
        checkOutResponse.setStatus(savedOrder.getStatus());
        checkOutResponse.setSubTotal(savedOrder.getSubTotal());
        checkOutResponse.setOrder(savedOrder);
        return checkOutResponse;
    }

    @Override
    public Order findOrderBy(String userId) {
        Order userOrder = orderRepo.findByUserId(userId);
        return userOrder;
    }

    @Override
    public Order updateOrderStatus(PaymentProcessResponse paymentProcessResponse) {
        Order orderFound = orderRepo.findOrderBy(paymentProcessResponse.getOrderId());
        orderFound.setStatus(paymentProcessResponse.getOrderStatus());
        return orderRepo.save(orderFound);
    }

}
