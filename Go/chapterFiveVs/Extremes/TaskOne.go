package main

import "fmt"

func main(){
	var value int 
	var input int
	minimum := 100
	maximum := 0

	fmt.Print("\nHow many times do you want to use this application? ")
	fmt.Scanf("%d", &value)

	for i := 0; i < value; i++ {
		fmt.Print("Enter a number: ")
		fmt.Scan(&input)

		if maximum <= input {
			maximum = input
		} 
		if minimum >= input {
			minimum = input
		}
		

	}
	extremeTotalFound := minimum + maximum
	fmt.Printf("\nThe minimum is: %d\nThe maximum is: %d\nThe Sum of both numbers is: %d", minimum, maximum, extremeTotalFound)
}