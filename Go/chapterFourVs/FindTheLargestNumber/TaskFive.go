package main

import "fmt"

var largest = 0
var number = 0

func main(){
	
	fmt.Println("Enter a number:")
	largest = findLargestOfInputs()
	fmt.Printf("The largest number entered by the user is: %d", largest)
}
func findLargestOfInputs() int{
	for counter := 0; counter < 10; counter++ {
		fmt.Scan(&number)
		if number > largest{
			largest = number
		}
	}
	return largest
}