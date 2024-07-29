package main

import "fmt"

func main(){
	length := 0
	fmt.Print("What base length do you want your triangle to have? ")
	fmt.Scan(&length)

	for i := 0; i < length; i++ {
		for j := 0; j < i; j++ {
			fmt.Print("*  ")
		}
		fmt.Println()
	}
}