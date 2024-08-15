package com.semicolon.africa.data.services;

import com.semicolon.africa.data.domain.*;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.ProductRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static com.semicolon.africa.data.domain.Gender.MALE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServicesTest {
    @Autowired
    private UserServices userService;

    @Autowired
    private CartServices cartServices;

    @Autowired
    private ProductServices productServices;

    @Autowired
    private ItemServices itemServices;

    @Autowired
    private OrderServices orderServices;

    @Autowired
    private ProductRepository productRepo;
    private InitializeProductRequest initializeProductRequest;
    RegisterUserAuthenticationRequest signUpRequest;
    RegisterResponse response;


    @BeforeEach
    void setUpRegisterUserAuthentication(){
        cartServices.deleteAll();
        productRepo.deleteAll();
        signUpRequest = new RegisterUserAuthenticationRequest();
        signUpRequest.setFirstName("David");
        signUpRequest.setLastName("Ezeodo");
        signUpRequest.setGender(MALE);
        signUpRequest.setAddress("No1 Ezeodo close");
        signUpRequest.setDateOfBirth("05/06/1997");
        signUpRequest.setEmailAddress("xyz@gmail.com");
        signUpRequest.setPassword("1234");
        signUpRequest.setRole(Role.CUSTOMER);
        signUpRequest.setSessionStatus(SessionStatus.LOGGED_IN);

         response = userService.signUp(signUpRequest);

        assertThat(response.getFirstName(), is("David"));
        assertEquals("David your account has been created successfully.", response.getMessage());


    }
    @Test
    void test_that_CustomerIsSaved(){
        assertThat(response.getFirstName(), is("David"));
        assertEquals("David your account has been created successfully.", response.getMessage());
        System.out.println(response.getUserId());
    }

    @Test
    void testThat_UserCan_AddItemToAnEmptyCart(){

//        User sends an add to cart request
        AddToCartRequest addToCartRequest = new AddToCartRequest();

//        The request has an Item, quantity and userId
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Miniso: mouse");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(500));
        Product savedProduct = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest = new InitializeItemRequest();
        initializeItemRequest.setPrice(savedProduct.getPrice());
        initializeItemRequest.setProduct(savedProduct);
        initializeItemRequest.setQuantity(5);
        Item initializedItem = itemServices.initializeItem(initializeItemRequest);

        addToCartRequest.setItem(initializedItem);
        addToCartRequest.setQuantity(initializedItem.getQuantity());
        addToCartRequest.setUserId(response.getUserId());
//        we want to add the item to the user's cart

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest);
        assertThat(addToCartResponse.getItemListSize()
                , is(1));
//        The cart belonging to the user who sent the request can be found
//        The item can be added to the cart (arrayList) according the quantity of the items specified

    }
    @Test
    void that_ListOfItems_is2_afterAnItemIs_added(){

//        User sends an add to cart request
        AddToCartRequest addToCartRequest = new AddToCartRequest();

//        The request has an Item, quantity and userId
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Kitchen Utensil: spatula");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(12000));
        Product savedProduct = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest = new InitializeItemRequest();
        initializeItemRequest.setPrice(savedProduct.getPrice());
        initializeItemRequest.setProduct(savedProduct);
        initializeItemRequest.setQuantity(6);
        Item initializedItem = itemServices.initializeItem(initializeItemRequest);

        addToCartRequest.setItem(initializedItem);
        addToCartRequest.setQuantity(initializedItem.getQuantity());
        addToCartRequest.setUserId(response.getUserId());
        System.out.println(response.getUserId());

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest);
        assertThat(addToCartResponse.getItemListSize(), is(1));

        //        User sends an add to cart request
        AddToCartRequest addToCartRequest2 = new AddToCartRequest();

//        The request has an Item, quantity and userId
        InitializeProductRequest initializeProductRequest2 = new InitializeProductRequest();
        initializeProductRequest2.setName("HouseHold: Detergent");
        initializeProductRequest2.setPrice(BigDecimal.valueOf(2600));
        Product savedProduct2 = productServices.addProduct(initializeProductRequest2);

        InitializeItemRequest initializeItemRequest2 = new InitializeItemRequest();
        initializeItemRequest2.setPrice(savedProduct2.getPrice());
        initializeItemRequest2.setProduct(savedProduct2);
        initializeItemRequest2.setQuantity(4);
        Item initializedItem2 = itemServices.initializeItem(initializeItemRequest2);

        addToCartRequest2.setItem(initializedItem2);
        addToCartRequest2.setQuantity(initializedItem2.getQuantity());
        addToCartRequest2.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse2 = cartServices.addToCart(addToCartRequest2);
        assertThat(addToCartResponse2.getItemListSize(), is(2));

        RemoveItemFromCartRequest removeItemFromCartRequest = new RemoveItemFromCartRequest();
        removeItemFromCartRequest.setItem(initializedItem);
        removeItemFromCartRequest.setUserId(response.getUserId());
        List<Item> updatedListOfItems = cartServices.removeItemFromCart(removeItemFromCartRequest);

        assertThat(updatedListOfItems.size(), is(1));

    }

    @Test
    void test_That_ListSizeIs_2_After_1_ItemOutOf2_IsRemove_And1IsAdded(){

//        User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Electronics: PlayStation 5");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setPrice(savedProduct.getPrice());
        initializeItemRequest1.setProduct(savedProduct);
        initializeItemRequest1.setQuantity(6);
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);

        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse2 = cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse2.getItemListSize(), is(1));

//        Adding second item
        AddToCartRequest addToCartRequest2 = new AddToCartRequest();

//        Creating the second item
        InitializeProductRequest initializeProductRequest2 = new InitializeProductRequest();
        initializeProductRequest2.setName("Fashion: Red shirt");
        initializeProductRequest2.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct2 = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest2 = new InitializeItemRequest();
        initializeItemRequest2.setPrice(savedProduct2.getPrice());
        initializeItemRequest2.setProduct(savedProduct2);
        initializeItemRequest2.setQuantity(6);
        Item initializedItem2 = itemServices.initializeItem(initializeItemRequest2);

        addToCartRequest2.setItem(initializedItem2);
        addToCartRequest2.setQuantity(initializedItem2.getQuantity());
        addToCartRequest2.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse3 = cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse3.getItemListSize(), is(2));

        RemoveItemFromCartRequest removeItemFromCartRequest = new RemoveItemFromCartRequest();
        removeItemFromCartRequest.setUserId(response.getUserId());
        removeItemFromCartRequest.setItem(initializedItem1);
        List<Item> updatedListOfItems = cartServices.removeItemFromCart(removeItemFromCartRequest);
        assertThat(updatedListOfItems.size(), is(1));

        //        User sends 3rd add to cart request
        AddToCartRequest addToCartRequest3 = new AddToCartRequest();

        //        Creating third product
        InitializeProductRequest initializeProductRequest3 = new InitializeProductRequest();
        initializeProductRequest3.setName("Sport Apparel: Soccer ball");
        initializeProductRequest3.setPrice(BigDecimal.valueOf(12000));
        Product savedProduct3 = productServices.addProduct(initializeProductRequest3);

        //        Creating third item
        InitializeItemRequest initializeItemRequest3 = new InitializeItemRequest();
        initializeItemRequest3.setPrice(savedProduct.getPrice());
        initializeItemRequest3.setProduct(savedProduct3);
        initializeItemRequest3.setQuantity(6);
        Item initializedItem3 = itemServices.initializeItem(initializeItemRequest3);

        addToCartRequest3.setItem(initializedItem3);
        addToCartRequest3.setQuantity(initializedItem3.getQuantity());
        addToCartRequest3.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse= cartServices.addToCart(addToCartRequest3);
        assertThat(addToCartResponse.getItemListSize(), is(2));
    }

    @Test
    void test_That_CustomerCan_IncreaseQuantity_OfItemsInCart(){

//       User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Electronics: PlayStation 5");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setPrice(savedProduct.getPrice());
        initializeItemRequest1.setProduct(savedProduct);
        initializeItemRequest1.setQuantity(6);
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);

        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse.getItemListSize(), is(1));

        IncreaseItemQuantityRequest increaseItemQuantityRequest = new IncreaseItemQuantityRequest();
        increaseItemQuantityRequest.setItem(initializedItem1);
        increaseItemQuantityRequest.setProductId(initializedItem1.getProduct().getId());
        increaseItemQuantityRequest.setUserId(response.getUserId());

        int increasedItemQuantity = cartServices.increaseItemQuantity(increaseItemQuantityRequest);
        assertThat(increasedItemQuantity, is(7));

    }
    @Test
    void test_That_CustomerCan_ReduceQuantity_OfItemsInCart(){
        //       User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Electronics: PlayStation 5");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setPrice(savedProduct.getPrice());
        initializeItemRequest1.setProduct(savedProduct);
        initializeItemRequest1.setQuantity(6);
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);

        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse.getItemListSize(), is(1));

        ReduceItemQuantityRequest reduceItemQuantityRequest = new ReduceItemQuantityRequest();
        reduceItemQuantityRequest.setItem(initializedItem1);
        reduceItemQuantityRequest.setProductId(initializedItem1.getProduct().getId());
        reduceItemQuantityRequest.setUserId(response.getUserId());

        int increasedItemQuantity = cartServices.reduceItemQuantity(reduceItemQuantityRequest);
        assertThat(increasedItemQuantity, is(5));
    }

    @Test
    void test_That_CustomerCan_IncreaseQuantity_AnItem_Out_Of_3_OtherItemsInCart(){
//       User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Gadget: PlayStation 5");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct1 = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setPrice(savedProduct1.getPrice());
        initializeItemRequest1.setProduct(savedProduct1);
        initializeItemRequest1.setQuantity(6);
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);

        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse.getItemListSize(), is(1));

        //       User sends an add to cart request
        AddToCartRequest addToCartRequest2 = new AddToCartRequest();

//        Creating second item
        InitializeProductRequest initializeProductRequest2 = new InitializeProductRequest();
        initializeProductRequest2.setName("Baby Stuff: Diapers");
        initializeProductRequest2.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct2 = productServices.addProduct(initializeProductRequest2);

        InitializeItemRequest initializeItemRequest2 = new InitializeItemRequest();
        initializeItemRequest2.setPrice(savedProduct2.getPrice());
        initializeItemRequest2.setProduct(savedProduct2);
        initializeItemRequest2.setQuantity(2);
        Item initializedItem2 = itemServices.initializeItem(initializeItemRequest2);

        addToCartRequest2.setItem(initializedItem2);
        addToCartRequest2.setQuantity(initializedItem2.getQuantity());
        addToCartRequest2.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse3 = cartServices.addToCart(addToCartRequest2);
        assertThat(addToCartResponse3.getItemListSize(), is(2));


//       User sends an add to cart request
        AddToCartRequest addToCartRequest3 = new AddToCartRequest();

//        Creating 3rd item
        InitializeProductRequest initializeProductRequest3 = new InitializeProductRequest();
        initializeProductRequest3.setName("Home Appliance: Washing machine");
        initializeProductRequest3.setPrice(BigDecimal.valueOf(30400));
        Product savedProduct3 = productServices.addProduct(initializeProductRequest2);

        InitializeItemRequest initializeItemRequest3 = new InitializeItemRequest();
        initializeItemRequest3.setPrice(savedProduct3.getPrice());
        initializeItemRequest3.setProduct(savedProduct3);
        initializeItemRequest3.setQuantity(3);
        Item initializedItem3 = itemServices.initializeItem(initializeItemRequest3);

        addToCartRequest3.setItem(initializedItem3);
        addToCartRequest3.setQuantity(initializedItem2.getQuantity());
        addToCartRequest3.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse4 = cartServices.addToCart(addToCartRequest3);
        assertThat(addToCartResponse4.getItemListSize(), is(3));

        IncreaseItemQuantityRequest increaseItemQuantityRequest = new IncreaseItemQuantityRequest();
        increaseItemQuantityRequest.setItem(initializedItem2);
        increaseItemQuantityRequest.setUserId(response.getUserId());
        increaseItemQuantityRequest.setProductId(initializedItem2.getProduct().getId());

        int updatedQuantity = itemServices.increaseItemQuantity(increaseItemQuantityRequest);

        assertThat(updatedQuantity, is(initializedItem2.getQuantity() +1));

    }

    @Test
    void test_That_OrderIsCreated_WhenCustomerChecksOut(){

//       User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        InitializeProductRequest initializeProductRequest1 = new InitializeProductRequest();
        initializeProductRequest1.setName("Gadget: PlayStation 5");
        initializeProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct1 = productServices.addProduct(initializeProductRequest1);

        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setPrice(savedProduct1.getPrice());
        initializeItemRequest1.setProduct(savedProduct1);
        initializeItemRequest1.setQuantity(6);
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);

        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse1= cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse1.getItemListSize(), is(1));

        //       User sends an add to cart request
        AddToCartRequest addToCartRequest2 = new AddToCartRequest();

//        Creating second item
        InitializeProductRequest initializeProductRequest2 = new InitializeProductRequest();
        initializeProductRequest2.setName("Baby Stuff: Diapers");
        initializeProductRequest2.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct2 = productServices.addProduct(initializeProductRequest2);

        InitializeItemRequest initializeItemRequest2 = new InitializeItemRequest();
        initializeItemRequest2.setPrice(savedProduct2.getPrice());
        initializeItemRequest2.setProduct(savedProduct2);
        initializeItemRequest2.setQuantity(2);
        Item initializedItem2 = itemServices.initializeItem(initializeItemRequest2);

        addToCartRequest2.setItem(initializedItem2);
        addToCartRequest2.setQuantity(initializedItem2.getQuantity());
        addToCartRequest2.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse2= cartServices.addToCart(addToCartRequest2);
        assertThat(addToCartResponse2.getItemListSize(), is(2));

        ShoppingCart cartFound = cartServices.findCartByUserId(response.getUserId());

        CheckOutRequest checkOutRequest = new CheckOutRequest();
        checkOutRequest.setId("123");
        checkOutRequest.setUserId(response.getUserId());
        checkOutRequest.setItems(cartFound.getItems());
        checkOutRequest.setSubTotal(BigDecimal.valueOf(1000.00));
        checkOutRequest.setPaymentMethod(PaymentMethod.BANK_TRANSFER);
        checkOutRequest.setBillingAddress(response.getAddress());
        checkOutRequest.setItems(cartServices.findAllItemsBy(response.getUserId()));
        checkOutRequest.setStatus(OrderStatus.PENDING);
        CheckOutResponse orderCreated = orderServices.createAnOrder(checkOutRequest);

        assertThat(orderCreated.getId(), is(checkOutRequest.getId()));
    }
//    @Test
//    void testThat_UserCanLogOut_OfApp(){
//        LogOutRequest logOutRequest = new LogOutRequest();
//        logOutRequest.setUserId(response.getUserId());
//
//        User userFound = userService.findUserById(logOutRequest.getUserId());
//        assertThat(userFound.getSessionStatus(), is(SessionStatus.LOGGED_IN));
//
//        LogOutResponse status = userService.logOut(logOutRequest);
//        assertThat(status.getSessionStatus(), is(SessionStatus.LOGGED_OUT));
//    }
//    @Test
//    void testThat_userCanVerifyLogIn_WhenLoggedOut(){
//        LogOutRequest logOutRequest = new LogOutRequest();
//        logOutRequest.setUserId(response.getUserId());
//
//        User userFound = userService.findUserById(logOutRequest.getUserId());
//        assertThat(userFound.getSessionStatus(), is(SessionStatus.LOGGED_IN));
//
//        LogOutResponse status = userService.logOut(logOutRequest);
//        assertThat(status.getSessionStatus(), is(SessionStatus.LOGGED_OUT));
//
//        LogInRequest logInRequest = new LogInRequest();
//        logInRequest.setEmail(userFound.getEmail());
//        logInRequest.setUserId(response.getUserId());
//        logInRequest.setSessionStatus(userFound.getSessionStatus());
//        logInRequest.setPassword(userFound.getPassword());
//
//        LogInResponse sessionStatus = userService.verifyLoginDetails(logInRequest);
//        assertThat(sessionStatus.getSessionStatus(), is(SessionStatus.LOGGED_IN));
//    }

}