package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.dtos.request.AddToCartRequest;
import com.semicolon.africa.dtos.request.ReduceItemQuantityRequest;
import com.semicolon.africa.dtos.request.RemoveItemFromCartRequest;
import com.semicolon.africa.dtos.request.IncreaseItemQuantityRequest;

import java.util.List;

public interface CartServices {
    public List<Item> addToCart(AddToCartRequest request);
    public List<Item> removeItemFromCart(RemoveItemFromCartRequest request);
    public Item findItemByProductId(List<Item> listOfItemsFound, String itemProductId);
    public List<Item> findAllItemsBy(String userId);
    public int findNumberOfItemsInCart(List<Item> items);
    public ShoppingCart findCartByUserId(String userId);
    public void save(ShoppingCart shoppingCart);
    public int increaseItemQuantity(IncreaseItemQuantityRequest increaseItemQuantityRequest);
    public int reduceItemQuantity(ReduceItemQuantityRequest reduceItemQuantityRequest);
    public void deleteAll();
}
