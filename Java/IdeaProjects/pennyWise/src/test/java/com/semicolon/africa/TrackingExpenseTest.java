package com.semicolon.africa;

import com.semicolon.africa.data.domain.Expense;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.requests.CreateUserRequest;
import com.semicolon.africa.dtos.requests.FindExpenseByAmountRequest;
import com.semicolon.africa.dtos.requests.ManuallyLogTransactionHistoryRequest;
import com.semicolon.africa.dtos.responses.CreateTransactionHistoryResponse;
import com.semicolon.africa.services.ExpenseJournalServices;
import com.semicolon.africa.services.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest
public class TrackingExpenseTest {

    private ExpenseJournalServices expenseJournalServices;
    private UserServices userServices;

    @Autowired
    public void setUserServices(UserServices userServices){
        this.userServices = userServices;
    }
    @Autowired
    public void setExpenseJournalServices(ExpenseJournalServices expenseJournalServices){
        this.expenseJournalServices = expenseJournalServices;
    }

    @BeforeEach
    void test_ThatUserCan_CreatAccount(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("John");
        createUserRequest.setLastName("Doe");
        createUserRequest.setAddress("NorthHampton Dr. 1823");
        createUserRequest.setOccupation("Stock broker");
        createUserRequest.setMonthlyEarning(180000L);
        User savedUser = userServices.createUser(createUserRequest);
        assertThat(savedUser.getFirstName()).isEqualTo("John");
        assertThat(savedUser.getId()).isNotNull();
    }
    @Test
    void test_ThatUserLogTransactionHistoryManually(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("John");
        createUserRequest.setLastName("Doe");
        createUserRequest.setAddress("NorthHampton Dr. 1823");
        createUserRequest.setOccupation("Stock broker");
        createUserRequest.setMonthlyEarning(180000L);
        User savedUser = userServices.createUser(createUserRequest);
        assertThat(savedUser.getFirstName()).isEqualTo("John");
        assertThat(savedUser.getId()).isNotNull();

        ManuallyLogTransactionHistoryRequest manuallyLogTransactionHistoryRequest = new ManuallyLogTransactionHistoryRequest();
        manuallyLogTransactionHistoryRequest.setDateOfTransaction("11/8/2024");
        manuallyLogTransactionHistoryRequest.setTimeOfTransaction("3:24pm");
        manuallyLogTransactionHistoryRequest.setAmountSpent(BigDecimal.valueOf(1200));
        manuallyLogTransactionHistoryRequest.setDescription("Swarovski Engagement ring");
        manuallyLogTransactionHistoryRequest.setUserId(savedUser.getId());
        manuallyLogTransactionHistoryRequest.setMonth(Month.AUGUST);
        CreateTransactionHistoryResponse savedJournal = expenseJournalServices.logTransactionData(manuallyLogTransactionHistoryRequest);
        assertThat(savedJournal.getDescription()).isEqualTo("Swarovski Engagement ring");
    }
    @Test
    void test_ThatUserCanFindList_OfExpenses(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("John");
        createUserRequest.setLastName("Doe");
        createUserRequest.setAddress("NorthHampton Dr. 1823");
        createUserRequest.setOccupation("Stock broker");
        createUserRequest.setMonthlyEarning(180000L);
        User savedUser = userServices.createUser(createUserRequest);
        assertThat(savedUser.getFirstName()).isEqualTo("John");
        assertThat(savedUser.getId()).isNotNull();

        ManuallyLogTransactionHistoryRequest manuallyLogTransactionHistoryRequest1 = new ManuallyLogTransactionHistoryRequest();
        manuallyLogTransactionHistoryRequest1.setDateOfTransaction("15/2/2024");
        manuallyLogTransactionHistoryRequest1.setTimeOfTransaction("1:16pm");
        manuallyLogTransactionHistoryRequest1.setAmountSpent(BigDecimal.valueOf(120800));
        manuallyLogTransactionHistoryRequest1.setDescription("Mercedes Benz GLE 2023");
        manuallyLogTransactionHistoryRequest1.setUserId(savedUser.getId());
        manuallyLogTransactionHistoryRequest1.setMonth(Month.AUGUST);
        CreateTransactionHistoryResponse savedJournal = expenseJournalServices.logTransactionData(manuallyLogTransactionHistoryRequest1);
        assertThat(savedJournal.getDescription()).isEqualTo("Mercedes Benz GLE 2023");

        ManuallyLogTransactionHistoryRequest manuallyLogTransactionHistoryRequest2 = new ManuallyLogTransactionHistoryRequest();
        manuallyLogTransactionHistoryRequest2.setDateOfTransaction("3/5/2024");
        manuallyLogTransactionHistoryRequest2.setTimeOfTransaction("12:24pm");
        manuallyLogTransactionHistoryRequest2.setAmountSpent(BigDecimal.valueOf(900));
        manuallyLogTransactionHistoryRequest2.setDescription("Dinner date with babe");
        manuallyLogTransactionHistoryRequest2.setUserId(savedUser.getId());
        manuallyLogTransactionHistoryRequest2.setMonth(Month.AUGUST);
        CreateTransactionHistoryResponse savedJournal2 = expenseJournalServices.logTransactionData(manuallyLogTransactionHistoryRequest2);
        assertThat(savedJournal2.getDescription()).isEqualTo("Dinner date with babe");

        ManuallyLogTransactionHistoryRequest manuallyLogTransactionHistoryRequest3 = new ManuallyLogTransactionHistoryRequest();
        manuallyLogTransactionHistoryRequest3.setDateOfTransaction("31/4/2024");
        manuallyLogTransactionHistoryRequest3.setTimeOfTransaction("3:24pm");
        manuallyLogTransactionHistoryRequest3.setAmountSpent(BigDecimal.valueOf(180));
        manuallyLogTransactionHistoryRequest3.setDescription("Coco Chanel perfume");
        manuallyLogTransactionHistoryRequest3.setUserId(savedUser.getId());
        manuallyLogTransactionHistoryRequest3.setMonth(Month.AUGUST);
        CreateTransactionHistoryResponse savedJournal3 = expenseJournalServices.logTransactionData(manuallyLogTransactionHistoryRequest3);
        assertThat(savedJournal3.getDescription()).isEqualTo("Coco Chanel perfume");

        FindExpenseByAmountRequest findExpenseByAmountRequest = new FindExpenseByAmountRequest();
        findExpenseByAmountRequest.setDateTime(manuallyLogTransactionHistoryRequest3.getDateOfTransaction());
        List<Expense> expensesFound = expenseJournalServices.findExpenseBy(findExpenseByAmountRequest);
        assertThat(expensesFound).isNotNull();
    }
}
