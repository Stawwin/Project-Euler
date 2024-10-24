package main

import (
	"fmt"
	"math/big"
	"os"
	"strconv"
)

func printReverseList(arr []int) []int {
	reversed := make([]int, 0, len(arr)) // Initialize an empty slice with the same capacity as arr
	for i := len(arr) - 1; i >= 0; i-- {
		reversed = append(reversed, arr[i])
	}
	return reversed
}

func concatenateDigits(arr []int) int {
	result := 0
	for _, digit := range arr {
		result = result*10 + digit
	}
	return result
}

func factorialRightMostNonZeroDigits(n int64, count int) int {
	result := big.NewInt(1)
	var rightMostNonZero []int

	for i := int64(1); i <= n; i++ {
		result.Mul(result, big.NewInt(i))
	}

	// Find the rightmost non-zero digits
	for result.Cmp(big.NewInt(0)) > 0 && len(rightMostNonZero) < count {
		lastDigit := new(big.Int).Mod(result, big.NewInt(10))
		if lastDigit.Cmp(big.NewInt(0)) != 0 {
			rightMostNonZero = append(rightMostNonZero, int(lastDigit.Int64()))
		}
		result.Div(result, big.NewInt(10))
	}

	return concatenateDigits(printReverseList(rightMostNonZero))
	// return rightMostNonZero
}

func main() {
	var input int
	var err error
	input, err = strconv.Atoi(os.Args[1])
	if err != nil {
		// if there's an error in conversion, print it and exit
		panic(err)
	}
	number := int64(input) // Change the number here
	count := 5

	rightMost := factorialRightMostNonZeroDigits(number, count)
	fmt.Println(rightMost)
}
