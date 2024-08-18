package com.semicolon.africa.services;

import com.semicolon.africa.Exceptions.CartIsEmptyException;
import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.data.repositories.CartRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.AddToCartResponse;
import com.semicolon.africa.dtos.response.IncreaseQuantityResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service @RequiredArgsConstructor
public class CartServicesImpl implements CartServices {

    private final CartRepository cartRepo;


    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        cartRepo.save(shoppingCart);
        return shoppingCart;
    }

    private BigDecimal findSubTotal(FindSubTotalRequest findSubTotalRequest) {
        List<Item> cartItems = findSubTotalRequest.getItems();
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal quantityOfItems;
        if(!cartItems.isEmpty()){
            for(Item item : cartItems){
                quantityOfItems = BigDecimal.valueOf(item.getQuantity()) ;
                subTotal = subTotal.add(quantityOfItems.multiply(item.getPrice()));
            }
            System.out.println(subTotal);

            return subTotal;
        };
        throw new CartIsEmptyException("No items with subtotal.");
    }

    @Override
    public AddToCartResponse addToCart(AddToCartRequest request) {
        AddToCartResponse addToCartResponse = new AddToCartResponse();
        ShoppingCart shoppingCartFound = findCartByUserId(request.getUserId());
        List<Item> items = shoppingCartFound.getItems();
        items.add(request.getItem());

        FindSubTotalRequest findSubTotalRequest = new FindSubTotalRequest();
        findSubTotalRequest.setItems(items);
        BigDecimal subTotal = findSubTotal(findSubTotalRequest);

        shoppingCartFound.setItems(items);
        shoppingCartFound.setSubTotal(subTotal);
        ShoppingCart shoppingCartUpdated = cartRepo.save(shoppingCartFound);
        addToCartResponse.setMessage("Item added successfully.");
        addToCartResponse.setItemListSize(shoppingCartUpdated.getItems().size());
        addToCartResponse.setCartSubTotal(subTotal);
        return addToCartResponse;
    }

    @Override
    public List<Item> removeItemFromCart(@NotNull RemoveItemFromCartRequest request) {
        ShoppingCart shoppingCartFound = findCartByUserId(request.getUserId());
        List<Item> items = shoppingCartFound.getItems();
        boolean listIsNotEmpty = !items.isEmpty();
        if(listIsNotEmpty){
            for(Item item : items){
                if(item.getProduct().getId().equals(request.getItem().getProduct().getId())){
                    items.remove(item);
                    cartRepo.save(shoppingCartFound);
                    return items;
                }
            }
        }
        throw new IllegalArgumentException("No cart with userId found.");
    }

    @Override
    public List<Item> findAllItemsBy(String userId) {
        ShoppingCart shoppingCart = findCartByUserId(userId);
        List<Item> items = shoppingCart.getItems();
        return items;
    }

    @Override
    public int findNumberOfItemsInCart(List<Item> items){
        return items.size();
    }


    @Override
    public IncreaseQuantityResponse increaseItemQuantity(IncreaseItemQuantityRequest increaseItemQuantityRequest) {
        IncreaseQuantityResponse increaseQuantityResponse = new IncreaseQuantityResponse();
        ShoppingCart shoppingCartFound = cartRepo.findCartByUserId(increaseItemQuantityRequest.getUserId());
        List<Item> listOfItemsFound = shoppingCartFound.getItems();
        String productId = increaseItemQuantityRequest.getProductId();
        Item itemToUpdate = findItemByProductId(listOfItemsFound, productId);
        int quantityValue = itemToUpdate.getQuantity();
        itemToUpdate.setQuantity(quantityValue +1);
        ShoppingCart shoppingCartWithUpdatedItemInList = cartRepo.save(shoppingCartFound);
        List<Item> updatedItems = shoppingCartWithUpdatedItemInList.getItems();
        Item updatedItem =  findItemByProductId(updatedItems, productId);
        int updatedQuantity = updatedItem.getQuantity();
        increaseQuantityResponse.setCartId(shoppingCartWithUpdatedItemInList.getId());
        increaseQuantityResponse.setQuantity(quantityValue);
        return increaseQuantityResponse;
    }

    @Override
    public int reduceItemQuantity(ReduceItemQuantityRequest reduceItemQuantityRequest) {
        ShoppingCart shoppingCartFound = cartRepo.findCartByUserId(reduceItemQuantityRequest.getUserId());
        List<Item> listOfItemsFound = shoppingCartFound.getItems();
        String productId = reduceItemQuantityRequest.getProductId();
        Item itemToUpdate = findItemByProductId(listOfItemsFound, productId);
        int quantityValue = itemToUpdate.getQuantity();
        itemToUpdate.setQuantity(quantityValue -1);
        ShoppingCart shoppingCartWithUpdatedItemInList = cartRepo.save(shoppingCartFound);
        List<Item> updatedItems = shoppingCartWithUpdatedItemInList.getItems();
        Item updatedItem =  findItemByProductId(updatedItems, productId);
        int updatedQuantity = updatedItem.getQuantity();
        return updatedQuantity;
    }


    public Item findItemByProductId(@NotNull List<Item> listOfItemsFound, String itemProductId){
        for(Item item : listOfItemsFound){
            if (item.getProduct().getId().equals(itemProductId)){
                 Item itemToUpdate = item;
                return itemToUpdate;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
    @Override
    public void clearCart() {
        cartRepo.deleteAll();
    }



    @Override
    public ShoppingCart findCartByUserId(String userId){
        ShoppingCart userShoppingCartFound =  cartRepo.findCartByUserId(userId);
        return userShoppingCartFound;
    }

}
