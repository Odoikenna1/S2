package com.semicolon.africa.services;
import com.semicolon.africa.Exceptions.UserAlreadyExistsException;
import com.semicolon.africa.Exceptions.UserDoesNotExistException;
import com.semicolon.africa.data.domain.SessionStatus;
import com.semicolon.africa.data.domain.ShoppingCart;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.LogOutResponse;
import com.semicolon.africa.dtos.response.ProductFoundResponse;
import com.semicolon.africa.dtos.response.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final CartServices cartService;

    private final UserRepository userRepository;

    @Override
    public UserSignUpResponse signUp(@NotNull RegisterUserRequest signUpRequestData) {
        User newUser = new User();
        ShoppingCart userCart = new ShoppingCart();
        newUser.setFirstName(signUpRequestData.getFirstName());
        newUser.setLastName(signUpRequestData.getLastName());
        newUser.setEmail(validateEmail(signUpRequestData.getEmailAddress()));
        newUser.setPassword(signUpRequestData.getPassword());
        newUser.setLoggedIn(true);
        User savedUser = userRepository.save(newUser);

        userCart.setUserId(savedUser.getUserId());
        ShoppingCart savedCart = cartService.save(userCart);
        UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
        userSignUpResponse.setUserId(savedUser.getUserId());
        userSignUpResponse.setFirstName(savedUser.getFirstName());
        userSignUpResponse.setMessage(String.format("%s your account has been created successfully.", savedUser.getFirstName()));
        userSignUpResponse.setShoppingCartId(savedCart.getId());
        userSignUpResponse.setLoggedIn(savedUser.isLoggedIn());
        return userSignUpResponse;
    }

    public String validateEmail(String userEmail){
        if(!userRepository.existsByEmail(userEmail)){
            return userEmail;
        }
        throw new UserAlreadyExistsException("A user with this email already exists.");
    }

    @Override
    public boolean validateUserBy(String userId) {
        if(userRepository.existsByUserId(userId)){return true;}
        return false;
    }

    @Override
    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(()->
                new UserDoesNotExistException("User not found"));
    }

    @Override
    public LogOutResponse logOut(LogOutRequest logOutRequest) {
        LogOutResponse logOutResponse = new LogOutResponse();
        User userFound = userRepository.findUserByUserId(logOutRequest.getUserId());
        if(userFound.isLoggedIn()) {
            userFound.setLoggedIn(false);
            logOutResponse.setLoggedIn(userFound.isLoggedIn());
            return logOutResponse;
        }
        throw new IllegalArgumentException("Invalid request.");
    }



//    @Override
//    public ProductFoundResponse findProduct(SearchProductRequest searchProductRequest) {
//
//        return null;
//    }

    @Override
    public LogInResponse verifyLoginDetails(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        User userFound = findUserById(logInRequest.getUserId());
        boolean email  = userFound.getEmail() == logInRequest.getEmail();
        boolean passwordIsCorrect = userFound.getPassword() == logInRequest.getPassword();
        if(email && passwordIsCorrect){
            logInResponse.setUserId(userFound.getUserId());
            logInResponse.setSessionStatus(SessionStatus.LOGGED_IN);
            return logInResponse;
        }
        throw new IllegalArgumentException("Invalid request.");
    }



}


