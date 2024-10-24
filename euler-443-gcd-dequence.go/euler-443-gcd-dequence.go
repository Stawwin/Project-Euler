package main // package declaration for the main package

import (
	"fmt"
	"os"
	"strconv"
)

// function gcd calculates the greatest common divisor of two numbers
func gcd(a, b int) int { // function declaration for calculating GCD
	for b != 0 { // start of a loop to find GCD
		a, b = b, a%b // Euclidean algorithm to find GCD
	}
	return a // return the GCD
}

// function g computes the value of g(n) based on the provided definition
func g(n int) int { // function to calculate g(n)
	if n == 4 { // check if n is equal to 4
		return 13 // return 13 as defined in the problem
	}

	prevG := g(n - 1) // recursively call g function
	return prevG + gcd(n, prevG) // calculate g(n) using the defined formula
}

func main() { // main function
	var input int
	var err error
	input, err = strconv.Atoi(os.Args[1]) // input from command line
	if err != nil {
		// if there is conversion to integer error, exit
		panic(err)
	}
	result := g(input) // calculate g(n)
	fmt.Printf("%d\n", result) // print the value of g(n)
}
