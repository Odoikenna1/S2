package com.semicolon.africa.data.services;

import com.semicolon.africa.Exceptions.UserAlreadyExistsException;
import com.semicolon.africa.data.domain.*;
import com.semicolon.africa.data.repositories.OrderRepository;
import com.semicolon.africa.data.repositories.ProductRepository;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    private CustomerServices customerServices;

    @Autowired
    private PaymentServices paymentServices;



    @Autowired
    RegisterUserRequest signUpRequest;
    UserSignUpResponse response;
    CustomerServicesImpl customerServicesImpl;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    private OrderRepository orderRepository;


    @BeforeEach
    void setUpRegisterUserAuthentication(){
        userRepository.deleteAll();
        signUpRequest = new RegisterUserRequest();
        signUpRequest.setFirstName("David");
        signUpRequest.setLastName("Ezeodo");
        signUpRequest.setEmailAddress("xyz@gmail.com");
        signUpRequest.setPassword("1234");
        signUpRequest.setRole(Role.CUSTOMER);

         response = userService.signUp(signUpRequest);

        assertThat(response.getFirstName(), is("David"));
        assertEquals("David your account has been created successfully.", response.getMessage());
    }

    @Test
    void test_that_CustomerIsSaved(){
        assertThat(response.getFirstName(), is("David"));
        assertEquals("David your account has been created successfully.", response.getMessage());
        System.out.println(response.getUserId());
        //asserT
    }

    @Test
    void test_ThatUserCartIsCreated_WhenUserIsCreated(){
        assertThat(response.getShoppingCartId(), is(notNullValue()));
    }
    @Test
    void testThat_UserId_Is_SetAfterUserIsSaved(){
        assertThat(response.getUserId(), is(notNullValue()));
    }
    @Test
    void testThat_theUserCartCanBeFoundByUserId(){
        ShoppingCart cartFound = cartServices.findCartByUserId(response.getUserId());
        assertThat(cartFound, is(notNullValue()));
    }
    @Test
    void test_ThatExceptionIsThrown_When_UserRegistersWithAnEmail_ThatAlreadyExists(){
        assertThat(response.getFirstName(), is("David"));
        assertEquals("David your account has been created successfully.", response.getMessage());
        System.out.println(response.getUserId());

        signUpRequest = new RegisterUserRequest();
        signUpRequest.setFirstName("David");
        signUpRequest.setLastName("Ezeodo");
        signUpRequest.setEmailAddress("xyz@gmail.com");
        signUpRequest.setPassword("1234");
        signUpRequest.setRole(Role.CUSTOMER);

        assertThrows(UserAlreadyExistsException.class, () -> userService.signUp(signUpRequest));
    }
    @Test
    void test_thatUserCanCreateA_Product(){
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setName("Washing machine");
        createProductRequest.setPrice(BigDecimal.valueOf(185600));
        createProductRequest.setCategory(Category.HOME_APPLIANCES);
        createProductRequest.setStock(50);
        Product savedProduct = productServices.addProduct(createProductRequest);
        assertThat(savedProduct, is(notNullValue()));

        CreateProductRequest createProductRequest2 = new CreateProductRequest();
        createProductRequest2.setName("Gucci slides");
        createProductRequest2.setPrice(BigDecimal.valueOf(86000));
        createProductRequest2.setCategory(Category.FASHION);
        createProductRequest.setStock(100);
        Product savedProduct2 = productServices.addProduct(createProductRequest2);
        assertThat(savedProduct2, is(notNullValue()));

        CreateProductRequest createProductRequest3 = new CreateProductRequest();
        createProductRequest3.setName("Mac book pro");
        createProductRequest3.setPrice(BigDecimal.valueOf(2_535_050));
        createProductRequest3.setCategory(Category.GADGETS);
        createProductRequest3.setStock(80);
        Product savedProduct3 = productServices.addProduct(createProductRequest3);
        assertThat(savedProduct3, is(notNullValue()));

        CreateProductRequest createProductRequest4 = new CreateProductRequest();
        createProductRequest4.setName("Hermes Birkin bag");
        createProductRequest4.setPrice(BigDecimal.valueOf(1_200_8500));
        createProductRequest4.setCategory(Category.FASHION);
        createProductRequest4.setStock(90);
        Product savedProduct4 = productServices.addProduct(createProductRequest4);
        assertThat(savedProduct4, is(notNullValue()));
    }
    @Test
    void testThat_UserCan_AddItemToAnEmptyCart(){

//        Pre-requisites:
//        Given that a user exists, a cart has a user
//        and given that products exist In the database

        ShoppingCart userCartFound = cartServices.findCartByUserId(response.getUserId());
        assertThat(userCartFound, is(notNullValue()));
        assertThat(userCartFound.getItems().size(), is(0));

//        Action:
//        A user can search and add items to cart
        SearchProductRequest searchProductRequest = new SearchProductRequest();
        searchProductRequest.setProductName("Gucci slides");

        ProductFoundResponse productFoundResponse= productServices.findProductBy(searchProductRequest);
        Product productFound= productFoundResponse.getProduct();
        assertThat(productFound, is(notNullValue()));

        InitializeItemRequest initializeItemRequest = new InitializeItemRequest();
        initializeItemRequest.setQuantity(4);
        initializeItemRequest.setPrice(productFound.getPrice());
        initializeItemRequest.setCartId(userCartFound.getId());
        initializeItemRequest.setProduct(productFound);

        Item initializedItem = itemServices.initializeItem(initializeItemRequest);

        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setItem(initializedItem);
        addToCartRequest.setQuantity(initializedItem.getQuantity());
        addToCartRequest.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest);
//      Assert that the customer's shopping cart list of item size is 1 after an item has been added
        assertThat(addToCartResponse.getItemListSize(), is(1));

    }
    @Test
    void test_that_ListOfItems_is2_After_Adding2_Items(){

//        Pre-requisites:
//        Given that a user exists, a cart has a user
//        and given that products exist In the database

        ShoppingCart userCartFound = cartServices.findCartByUserId(response.getUserId());
        assertThat(userCartFound, is(notNullValue()));
        assertThat(userCartFound.getItems().size(), is(0));

//        Action:
//        A user can search for items and add them to cart
//        Search for first product (product1)
        SearchProductRequest searchProductRequest1 = new SearchProductRequest();
        searchProductRequest1.setProductName("Gucci slides");

        ProductFoundResponse productFoundResponse = productServices.findProductBy(searchProductRequest1);
        Product productFound1 = productFoundResponse.getProduct();
        assertThat(productFound1, is(notNullValue()));

//        Setup Initialize item request of item1 for item Services
        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setQuantity(4);
        initializeItemRequest1.setPrice(productFound1.getPrice());
        initializeItemRequest1.setCartId(userCartFound.getId());
        initializeItemRequest1.setProduct(productFound1);

//       Initialize first item using item services
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);
//        Make an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();
//        Set up the add to cart request
        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());
//        Pass the add to cart request of item1 to cart services
        AddToCartResponse addToCartResponse1 = cartServices.addToCart(addToCartRequest1);
//        Assert that user's cart list is now 1 after an item has been added to cart.
        assertThat(addToCartResponse1.getItemListSize(), is(1));

//        Action:
//        Search for second product (product2)
        SearchProductRequest searchProductRequest2 = new SearchProductRequest();
        searchProductRequest2.setProductName("Hermes Birkin bag");

        ProductFoundResponse productFoundResponse1 = productServices.findProductBy(searchProductRequest2);
        Product productFound2 = productFoundResponse1.getProduct();
        assertThat(productFound2, is(notNullValue()));

//        Set up the second Initialize item request of item2 for item Services
        InitializeItemRequest initializeItemRequest2 = new InitializeItemRequest();
        initializeItemRequest2.setQuantity(4);
        initializeItemRequest2.setPrice(productFound2.getPrice());
        initializeItemRequest2.setCartId(userCartFound.getId());
        initializeItemRequest2.setProduct(productFound2);

//       Initialize second item using item services
        Item initializedItem2 = itemServices.initializeItem(initializeItemRequest2);
//        Make an add to cart request
        AddToCartRequest addToCartRequest2 = new AddToCartRequest();
//        Set up the add to cart request
        addToCartRequest2.setItem(initializedItem2);
        addToCartRequest2.setQuantity(initializedItem2.getQuantity());
        addToCartRequest2.setUserId(response.getUserId());
//        Pass the add to cart request of item1 to cart services
        AddToCartResponse addToCartResponse2 = cartServices.addToCart(addToCartRequest2);
//        Assert that user's cart list is now 1 after an item has been added to cart.
        assertThat(addToCartResponse2.getItemListSize(), is(2));
    }

    @Test
    void test_ThatUserCartListSizeIs_1AfterOneOutOf2ItemsIsRemoved(){
//        Objective of test:
//        Testing that a user can remove an item from cart after searching and adding items to cart

//        Pre-requisites:
//        Given that a user exists, a cart has a user,
//        and given that products exist In the database.
//        User can add to and remove items from cart

//        First, test that user's cart can be found and that its empty
        ShoppingCart userCartFound = cartServices.findCartByUserId(response.getUserId());
        assertThat(userCartFound, is(notNullValue()));
        assertThat(userCartFound.getItems().size(), is(0));

//        Action:
//        A user can search for items and add them to cart
//        Search for first product (product1)
        SearchProductRequest searchProductRequest1 = new SearchProductRequest();
        searchProductRequest1.setProductName("Gucci slides");

        ProductFoundResponse productFoundResponse1 = productServices.findProductBy(searchProductRequest1);
        Product productFound1= productFoundResponse1.getProduct();
        assertThat(productFound1, is(notNullValue()));

//        Setup Initialize item request of item1 for item Services
        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setQuantity(4);
        initializeItemRequest1.setPrice(productFound1.getPrice());
        initializeItemRequest1.setCartId(userCartFound.getId());
        initializeItemRequest1.setProduct(productFound1);

//       Initialize first item using item services
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);
//        Make an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();
//        Set up the add to cart request
        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setQuantity(initializedItem1.getQuantity());
        addToCartRequest1.setUserId(response.getUserId());
//        Pass the add to cart request of item1 to cart services
        AddToCartResponse addToCartResponse1 = cartServices.addToCart(addToCartRequest1);
//        Assert that user's cart list is now 1 after an item has been added to cart.
        assertThat(addToCartResponse1.getItemListSize(), is(1));

//        Action:
//        Search for second product (product2)
        SearchProductRequest searchProductRequest2 = new SearchProductRequest();
        searchProductRequest2.setProductName("Hermes Birkin bag");

        ProductFoundResponse productFoundResponse2 = productServices.findProductBy(searchProductRequest2);
        Product productFound2= productFoundResponse2.getProduct();
        assertThat(productFound2, is(notNullValue()));

//        Set up the second Initialize item request of item2 for item Services
        InitializeItemRequest initializeItemRequest2 = new InitializeItemRequest();
        initializeItemRequest2.setQuantity(4);
        initializeItemRequest2.setPrice(productFound2.getPrice());
        initializeItemRequest2.setCartId(userCartFound.getId());
        initializeItemRequest2.setProduct(productFound2);

//       Initialize second item using item services
        Item initializedItem2 = itemServices.initializeItem(initializeItemRequest2);
//        Make an add to cart request
        AddToCartRequest addToCartRequest2 = new AddToCartRequest();
//        Set up the add to cart request
        addToCartRequest2.setItem(initializedItem2);
        addToCartRequest2.setQuantity(initializedItem2.getQuantity());
        addToCartRequest2.setUserId(response.getUserId());
//        Pass the add to cart request of item1 to cart services
        AddToCartResponse addToCartResponse2 = cartServices.addToCart(addToCartRequest2);
//        Assert that user's cart list is now 1 after an item has been added to cart.
        assertThat(addToCartResponse2.getItemListSize(), is(2));

//        Now that items have been added to cart
//        Test that user can remove item from cart.

        RemoveItemFromCartRequest removeItemFromCartRequest = new RemoveItemFromCartRequest();
        removeItemFromCartRequest.setUserId(response.getUserId());
        removeItemFromCartRequest.setItem(initializedItem1);
        List<Item> updatedList = cartServices.removeItemFromCart(removeItemFromCartRequest);
        assertThat(updatedList.size(), is(1));
    }

    @Test
    void test_ThatUserCanLogOut_UserLoggedInStatusBecomesFalse_OnceLogOutRequestIsFulfilled(){
//        Pre-requisite:
//        Given that a use exists
        assertThat(response.getFirstName(), is("David"));
        assertEquals("David your account has been created successfully.", response.getMessage());
//        Action:
//        A log-out request is sent

        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUserId(response.getUserId());
        userService.logOut(logOutRequest);
//        Assert: that,
//        his logged_in status becomes false
        LogOutResponse logOutResponse = new LogOutResponse();
        assertThat(logOutResponse.isLoggedIn(), is(false));
    }



    @Test
    void test_That_CustomerCan_IncreaseQuantity_OfItemsInCart(){

//       User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        CreateProductRequest createProductRequest1 = new CreateProductRequest();
        createProductRequest1.setName("PlayStation 5");
        createProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct = productServices.addProduct(createProductRequest1);

        InitializeItemRequest initializeItemRequest1 = new InitializeItemRequest();
        initializeItemRequest1.setPrice(savedProduct.getPrice());
        initializeItemRequest1.setProduct(savedProduct);
        initializeItemRequest1.setQuantity(6);
        Item initializedItem1 = itemServices.initializeItem(initializeItemRequest1);

        addToCartRequest1.setItem(initializedItem1);
        addToCartRequest1.setUserId(response.getUserId());

        AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest1);
        assertThat(addToCartResponse.getItemListSize(), is(1));

        IncreaseItemQuantityRequest increaseItemQuantityRequest = new IncreaseItemQuantityRequest();
        increaseItemQuantityRequest.setItem(initializedItem1);
        increaseItemQuantityRequest.setProductId(initializedItem1.getProduct().getId());
        increaseItemQuantityRequest.setUserId(response.getUserId());

        IncreaseQuantityResponse increaseQuantityResponse = cartServices.increaseItemQuantity(increaseItemQuantityRequest);
        assertThat(increaseQuantityResponse, is(7));

    }
    @Test
    void test_That_CustomerCan_ReduceQuantity_OfItemsInCart(){
        //       User sends an add to cart request
        AddToCartRequest addToCartRequest1 = new AddToCartRequest();

//        Creating the first item
        CreateProductRequest createProductRequest1 = new CreateProductRequest();
        createProductRequest1.setName("PlayStation 5");
        createProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct = productServices.addProduct(createProductRequest1);

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
        CreateProductRequest createProductRequest1 = new CreateProductRequest();
        createProductRequest1.setName("PlayStation 5");
        createProductRequest1.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct1 = productServices.addProduct(createProductRequest1);

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
        CreateProductRequest createProductRequest2 = new CreateProductRequest();
        createProductRequest2.setName("Diapers");
        createProductRequest2.setPrice(BigDecimal.valueOf(680400));
        Product savedProduct2 = productServices.addProduct(createProductRequest2);

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
        CreateProductRequest createProductRequest3 = new CreateProductRequest();
        createProductRequest3.setName("Washing machine");
        createProductRequest3.setPrice(BigDecimal.valueOf(30400));
        Product savedProduct3 = productServices.addProduct(createProductRequest2);

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
//      Objective:
//        Test that an order ticket is created when our endpoint gets a create order request
//        Pre-requisite;
//        Given that a user exists
        assertThat(userService.validateUserBy(response.getUserId()), is(true));
//        the user has added item to cart
        SearchProductRequest searchProductRequest = new SearchProductRequest();
        searchProductRequest.setProductName("Gucci slides");
        ProductFoundResponse productFoundResponse = productServices.findProductBy(searchProductRequest);
        Product productFound =productFoundResponse.getProduct();

        assertThat(productFound, is(notNullValue()));

        InitializeItemRequest initializeItemRequest = new InitializeItemRequest();
        initializeItemRequest.setProduct(productFound);
        initializeItemRequest.setPrice(productFound.getPrice());
        initializeItemRequest.setQuantity(5);
        Item initializedItem = itemServices.initializeItem(initializeItemRequest);

        assertThat(initializedItem, is(notNullValue()));

        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setUserId(response.getUserId());
        addToCartRequest.setItem(initializedItem);
        cartServices.addToCart(addToCartRequest);

//        he has reviewed his cart
//        Action:
//        user sends a check-out request
//        first, set billing information
        SetUpBillingInformationRequest setupBillingInformationRequest = new SetUpBillingInformationRequest();
        setupBillingInformationRequest.setBillingAddress("No1 odo close, lekki, lagos");
        setupBillingInformationRequest.setUserId(response.getUserId());
        setupBillingInformationRequest.setCountry("Nigeria");
        setupBillingInformationRequest.setZipCode("105102");
        setupBillingInformationRequest.setNationality("Nigerian");
        setupBillingInformationRequest.setPhoneNumber("09052901359");

//        next initiate check out request
       CheckOutRequest checkOutRequest = new CheckOutRequest();
       checkOutRequest.setUserId(response.getUserId());
       ShoppingCart cart = cartServices.findCartByUserId(response.getUserId());
       checkOutRequest.setItems(cart.getItems());
       checkOutRequest.setStatus(OrderStatus.PENDING);
       checkOutRequest.setPaymentMethod(PaymentMethod.BANK_TRANSFER);
       checkOutRequest.setSetupBillingInformationRequest(setupBillingInformationRequest);

       CheckOutResponse checkOutResponse =  customerServices.handleOrderRequest(checkOutRequest);

       assertThat(checkOutResponse.getSubTotal(), is(notNullValue()));
        System.out.println(checkOutResponse.getSubTotal());
       assertThat(checkOutResponse.getId(), is(notNullValue()));
        assertThat(checkOutResponse.getStatus(), is(OrderStatus.PENDING));

    }
    @Test
    void testThat_OrderStatusChangesToPaidWhenUserMakesPayment(){
//        Pre-requisite:
//        Given that a user exists,
//        a cart has a user
//        he adds item to cart
//        he checks out
//        Action:
//        He makes payment


        assertThat(userService.validateUserBy(response.getUserId()), is(true));
//        the user has added item to cart
        SearchProductRequest searchProductRequest = new SearchProductRequest();
        searchProductRequest.setProductName("Gucci slides");
        ProductFoundResponse productFoundResponse = productServices.findProductBy(searchProductRequest);
        Product productFound =productFoundResponse.getProduct();

        assertThat(productFound, is(notNullValue()));

        InitializeItemRequest initializeItemRequest = new InitializeItemRequest();
        initializeItemRequest.setProduct(productFound);
        initializeItemRequest.setPrice(productFound.getPrice());
        initializeItemRequest.setQuantity(5);
        Item initializedItem = itemServices.initializeItem(initializeItemRequest);

        assertThat(initializedItem, is(notNullValue()));

        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setUserId(response.getUserId());
        addToCartRequest.setItem(initializedItem);
        cartServices.addToCart(addToCartRequest);

//        he has reviewed his cart
//        Action:
//        user sends a check-out request
//        first, set billing information
        SetUpBillingInformationRequest setupBillingInformationRequest = new SetUpBillingInformationRequest();
        setupBillingInformationRequest.setBillingAddress("No1 odo close, lekki, lagos");
        setupBillingInformationRequest.setUserId(response.getUserId());
        setupBillingInformationRequest.setCountry("Nigeria");
        setupBillingInformationRequest.setZipCode("105102");
        setupBillingInformationRequest.setNationality("Nigerian");
        setupBillingInformationRequest.setPhoneNumber("09052901359");

//        next initiate check out request
        CheckOutRequest checkOutRequest = new CheckOutRequest();
        checkOutRequest.setUserId(response.getUserId());
        ShoppingCart cart = cartServices.findCartByUserId(response.getUserId());
        checkOutRequest.setItems(cart.getItems());
        checkOutRequest.setStatus(OrderStatus.PENDING);
        checkOutRequest.setPaymentMethod(PaymentMethod.BANK_TRANSFER);
        checkOutRequest.setSetupBillingInformationRequest(setupBillingInformationRequest);

        CheckOutResponse checkOutResponse =  customerServices.handleOrderRequest(checkOutRequest);

        assertThat(checkOutResponse.getSubTotal(), is(notNullValue()));
        System.out.println(checkOutResponse.getSubTotal());
        assertThat(checkOutResponse.getId(), is(notNullValue()));
        assertThat(checkOutResponse.getStatus(), is(OrderStatus.PENDING));

        Order orderFound = checkOutResponse.getOrder();

        assertThat(orderFound, is(notNullValue()));
        System.out.println(orderFound);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setUserId(response.getUserId());
        paymentRequest.setAmountToBePaid(BigDecimal.valueOf(500000));
//        orderServices.findOrderBy(response.getUserId()
        System.out.println(orderFound);
        paymentRequest.setOrder(orderFound);
        System.out.println(orderFound);


        PaymentProcessResponse paymentProcessResponse = paymentServices.processPayment(paymentRequest);

        Order updatedOrderStatus = orderServices.updateOrderStatus(paymentProcessResponse);

//        Assert;
//        that the order status changes to PAID.
        assertThat(updatedOrderStatus.getStatus(), is(OrderStatus.PAID));
    }


}