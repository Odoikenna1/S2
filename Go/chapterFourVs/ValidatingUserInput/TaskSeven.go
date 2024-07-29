package main

import "fmt"

func main(){
	var input int
	var counter = 5
	for i := 0; i < counter; i++ {
		fmt.Scan(&input)
		largest := input
		if input == largest {
			i--
		} 
	}
}