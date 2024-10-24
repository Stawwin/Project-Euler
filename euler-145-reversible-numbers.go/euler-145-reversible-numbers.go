package main

import (
	"fmt"
	"os"
	"strconv"
)

// checks if all digits of a number are odd
func isOdd(n int64) bool {
    // converts the integer to a string for digit iteration
    strNum := strconv.FormatInt(n, 10)

    // iterates through each digit
    for i := 0; i < len(strNum); i++ {
        // converts the digit back to an integer
        x, _ := strconv.Atoi(strNum[i : i+1])

        // if any digit is even, return false
        if x%2 == 0 {
            return false
        }
    }
    // if all digits are odd, return true
    return true
}

// reverses the digits of an integer
func IntReverse(n int64) int64 {
    reversed := int64(0)

    // reverses the digits of the number
    for n != 0 {
        reversed = reversed*10 + n%10
        n /= 10
    }

    return reversed
}

func main() {
	var input int
	var err error
	input, err = strconv.Atoi(os.Args[1]) // input from command line
	if err != nil {
		// if there is conversion to integer error, exit
		panic(err)
	}
    total := 0
    // iterates through numbers up to input
    for i := int64(0); i < int64(input); i++ {
        // checks if the sum of the number and its reverse has all odd digits and the number doesn't end with 0
        if isOdd(i+IntReverse(i)) && i%10 != 0 {
            total++
        }
    }

    fmt.Println(total)
}
