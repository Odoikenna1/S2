package main

import "fmt"

var taxRateFor30kEarning = 0.15
var taxRateForEaringsAbove30k = 0.20

type Citizen struct{
	name string
	taxId int
	earning float64
}
func main(){
	var name string; var taxId int; var earning float64
	fmt.Print("What is your name? "); fmt.Scan(&name)
	fmt.Print("What is your tax Id? "); fmt.Scan(&taxId)
	fmt.Print("What is your current earning? "); fmt.Scan(&earning)
	citizen1 := Citizen{
		name: name,
		taxId: taxId,
		earning: earning,
	}
	var taxBill float64
	if citizen1.earning <= 30000 {
		taxBill = taxRateFor30kEarning * float64(citizen1.earning)
	} else{
		taxBill = taxRateForEaringsAbove30k * float64(citizen1.earning)
	}
	fmt.Printf(`
		Name:  %s
		Tax Id: %d
		Tax Bill: %f 
	`, citizen1.name, citizen1.taxId, taxBill)
}