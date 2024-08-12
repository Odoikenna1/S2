package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Expense;
import com.semicolon.africa.data.repositories.ExpenseRepository;
import com.semicolon.africa.dtos.requests.FindExpenseByAmountRequest;
import com.semicolon.africa.dtos.requests.ManuallyLogTransactionHistoryRequest;
import com.semicolon.africa.dtos.responses.CreateTransactionHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class ExpenseJournalServicesImpl implements ExpenseJournalServices{

    private final ExpenseRepository journalRepository;
    private final ExpenseRepository expenseRepository;

    @Override
    public CreateTransactionHistoryResponse logTransactionData(ManuallyLogTransactionHistoryRequest manuallyLogTransactionHistoryRequest) {
        Expense journal = new Expense();
        CreateTransactionHistoryResponse c = new CreateTransactionHistoryResponse();
        journal.setDateOfTransaction(manuallyLogTransactionHistoryRequest.getDateOfTransaction());
        journal.setDescription(manuallyLogTransactionHistoryRequest.getDescription());
        journal.setTimeOfTransaction(manuallyLogTransactionHistoryRequest.getTimeOfTransaction());
        journal.setAmountSpent(manuallyLogTransactionHistoryRequest.getAmountSpent());
        journal.setUserId(manuallyLogTransactionHistoryRequest.getUserId());
        journal.setMonth(manuallyLogTransactionHistoryRequest.getMonth());
        journal.setLoggedtAt(manuallyLogTransactionHistoryRequest.getLoggedAt());
        Expense journalSaved = journalRepository.save(journal);
        CreateTransactionHistoryResponse createTransactionHistoryResponse = new CreateTransactionHistoryResponse();
        createTransactionHistoryResponse.setId(journalSaved.getId());
        createTransactionHistoryResponse.setUserId(journal.getUserId());
        createTransactionHistoryResponse.setDescription(journalSaved.getDescription());
        createTransactionHistoryResponse.setTime(journalSaved.getTimeOfTransaction());
        return createTransactionHistoryResponse;
    }

    @Override
    public List<Expense> findExpenseBy(FindExpenseByAmountRequest findExpenseByAmountRequest) {
        List<Expense> expenseFound = expenseRepository.findExpenseByDateOfTransaction(findExpenseByAmountRequest.getDateTime());
        return expenseFound;
    }
}
