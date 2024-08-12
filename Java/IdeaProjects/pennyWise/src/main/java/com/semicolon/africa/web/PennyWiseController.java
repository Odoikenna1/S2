package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.ManuallyLogTransactionHistoryRequest;
import com.semicolon.africa.dtos.responses.ApiResponse;
import com.semicolon.africa.dtos.responses.CreateTransactionHistoryResponse;
import com.semicolon.africa.services.ExpenseJournalServices;
import com.semicolon.africa.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PennyWiseController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ExpenseJournalServices expenseJournalServices;

    @PostMapping("api/v1/createJournal")
    public ResponseEntity<?> createJournal(@RequestBody ManuallyLogTransactionHistoryRequest request){
        try{
            CreateTransactionHistoryResponse response = expenseJournalServices.logTransactionData(request);
            return new ResponseEntity<>(new ApiResponse(response, true), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
}
