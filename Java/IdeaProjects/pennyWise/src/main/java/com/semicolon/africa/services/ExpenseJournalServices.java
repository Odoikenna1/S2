package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Expense;
import com.semicolon.africa.dtos.requests.FindExpenseByAmountRequest;
import com.semicolon.africa.dtos.requests.ManuallyLogTransactionHistoryRequest;
import com.semicolon.africa.dtos.responses.CreateTransactionHistoryResponse;

import java.util.List;

public interface ExpenseJournalServices {
    public CreateTransactionHistoryResponse logTransactionData(ManuallyLogTransactionHistoryRequest manuallyLogTransactionHistoryRequest);
    public List<Expense> findExpenseBy(FindExpenseByAmountRequest findExpenseByAmountRequest);
}
