package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.domain.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    public List<Expense> findExpenseByDateOfTransaction(String date);
}
