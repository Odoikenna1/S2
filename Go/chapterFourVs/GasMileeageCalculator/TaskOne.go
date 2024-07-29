package main

import (
	"fmt"
	
)

func main() {
	var index int = 1
	var milesDriven int
	var gallonsUsed int
	var totalMiles int
	var totalGallons int

	fmt.Println(`
	This is a gas mileage calculator.
	You will be prompted to enter miles driven and gallons used.
	Please use a space to separate miles driven from gallons used.
	You are required to input 0 to exit the application.
	`)
	
	for{
		fmt.Printf("Enter miles driven for trip %d and gallons used:  ", index)
		fmt.Scan(&milesDriven)
		if milesDriven == 0{ fmt.Println("Exiting application... "); break }
		fmt.Printf("Enter gallons used for trip %d:  ", index)
		fmt.Scan(&gallonsUsed)
		totalMiles += milesDriven
		totalGallons += gallonsUsed
		var average float64 = float64(totalMiles / totalGallons)
		fmt.Printf("Miles per gallon for trip %d is %f\n\n", index, average)
		index++
	}
}