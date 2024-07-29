package main

import "fmt"

func main(){

	column := 4
	row := 5
	for j := 0; j < column; j++ {
		fmt.Println("N")
		for i := 0; i < row; i++ {
			fmt.Printf("%d", i+1)
		}
	}
	
	
		
}