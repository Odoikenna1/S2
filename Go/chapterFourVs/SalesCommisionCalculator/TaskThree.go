package main

import "fmt"

var commission float64 = 0.09
var weeklyWages float64 = 200.00
var price float64 = 0.00
var total float64 =0.00

func main(){
	numberOfItemsSold := input("How many items have you sold this week? ")
	totalOfItemsSold := collectPrices(numberOfItemsSold)
	employeeCommission := findCommision(totalOfItemsSold)
	fmt.Printf("Employee commission is %f", employeeCommission)
}
func collectPrices(numberOfItemsSold int) float64{
	for i := 0; i  < numberOfItemsSold; i++ {
		fmt.Printf("Enter price for item %d: ", i+1)
		fmt.Scan(&price)
		total += price
	}
	return total
}
func input(prompt string) int{
	var value int
	fmt.Print(prompt)
	fmt.Scan(&value)
	return value
}
func findCommision(totalOfSales float64) float64{
	paymentDue := weeklyWages + totalOfSales * commission
	return paymentDue
}