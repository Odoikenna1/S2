package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.AddToCartResponse;
import com.semicolon.africa.dtos.response.IncreaseQuantityResponse;

import java.math.BigDecimal;
import java.util.List;

public interface CartServices {
    public ShoppingCart save(ShoppingCart shoppingCart);
    public AddToCartResponse addToCart(AddToCartRequest request);
    public List<Item> removeItemFromCart(RemoveItemFromCartRequest request);
    public Item findItemByProductId(List<Item> listOfItemsFound, String itemProductId);
    public List<Item> findAllItemsBy(String userId);
    public int findNumberOfItemsInCart(List<Item> items);
    public ShoppingCart findCartByUserId(String userId);
    public IncreaseQuantityResponse increaseItemQuantity(IncreaseItemQuantityRequest increaseItemQuantityRequest);
    public int reduceItemQuantity(ReduceItemQuantityRequest reduceItemQuantityRequest);
    public void clearCart();
}
