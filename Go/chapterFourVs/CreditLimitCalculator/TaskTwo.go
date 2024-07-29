package main

import "fmt"

func main() {
	// var newBalance int
	// var allowedCreditLimit int
	acctNum := input("What is your account number?  ")
	balCarriedDown := input("What is your balance at the beginning of the month?  ")
	totalOfAllItemsCharged := input("What is the cost of all items charged this month?  ")
	totalOfAllCreditsApplied := input("What is the cost of all total credits applied?  ")
	totalOfAllItemsChargedInMonth := input("What is the cost of all items charged in a month?  ")
	
	newBalance := balCarriedDown + totalOfAllItemsCharged - totalOfAllCreditsApplied
	fmt.Print(acctNum, totalOfAllItemsChargedInMonth, newBalance)
}

func input(prompt string) int {
	var value int
	fmt.Print(prompt)
	fmt.Scan(&value)
	return value
}