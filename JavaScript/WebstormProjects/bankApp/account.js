class Account{
    construct(){
        let accounts = [];
        const customerDetails = {
            firstName: "",
            lastName: "",
            phoneNumber: "",
            accountBalance: 0.00,
            pin: "",
            fullName: function (){
                return this.firstName + "" + this.lastName;
            }
        }
        function goToMainMenu()
        {
            let message = `
            \nWelcome to our bank.
            1 -> Create account     2 -> Deposit funds
            2 -> Withdraw funds     3 -> Check balance
            4 -> Transfer funds     5 -> Close account
            `;
            console.log(message);
        }
        goToMainMenu();
    
        const navigation = function(userOption)
        {
            switch(userOption)
            {
                case 1:
                    registerNewCustomer();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdrawFunds();
                    break;
    
            }
        }
        
        function registerNewCustomer() {
            let firstName = prompt("What is your first name? ");
            customerDetails.firstName = firstName;
            let lastName = prompt("What is your last name? ");
            customerDetails.lastName = lastName;
            let phoneNumber = prompt("What is your phone number? ");
            customerDetails.phoneNumber = phoneNumber;
            let pin = prompt("What is your pin? ");
            customerDetails.pin = pin;
            let accountNumber = phoneNumber.slice(1);
            customerDetails.accountNumber = accountNumber;

            accounts.push(customerDetails);
        }
        registerNewCustomer();
    
        function deposit()
        {
            const depositAmount = Number(prompt("How much do you want to deposit? "));
            customerDetails.account = depositAmount;
        }
        deposit();
        function withdrawFunds(){
            const withdrawAmount = Number(prompt("How much do you want to withdraw? "));
            let currentAccountBalance = customerDetails.accountBalance;
            currentAccountBalance = currentAccountBalance - withdrawAmount;
            customerDetails.accountBalance = currentAccountBalance;
        }
        withdrawFunds();
        function checkAccountBalance()
        {
            return customerDetails.accountBalance;
        }
        checkAccountBalance();
        function transferFunds()
        {
            let amountToBeTransfered = Number(prompt("How much do you want to transfer? "));
            let senderAccountNumber = prompt("Enter your account Number: ");
            let receiverAccountNumber = prompt("Enter your account Number: ");
            let senderPin = prompt("Enter your pin: ")
            if (senderAccountNumber === accounts.indexOf(customerDetails.accountNumber))
                {
                    if (senderPin === accounts.findIndex(customerDetails.pin))
                        {}
                }
        }

        
    }

}
    