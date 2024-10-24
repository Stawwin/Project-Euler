package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
)

// compute and count possible solutions for n = 1 to n = limit
func compute(limit int) int {
	// initialize an array to store the counts for each n
	array := make([]int, limit)

	// iterate over possible values of 'a'
	for a := 1; a < limit; a++ {
		// iterate over possible values of 'd'
		for d := int(math.Floor(float64(a)/4)) + 1; d < a; d++ {
			n := a * (4*d - a)

			// if n exceeds the limit, stop the loop for 'd'
			if n > limit-1 {
				break
			} else {
				// increment the count for the current value of n in the array
				array[n]++
			}
		}
	}

	// count how many times the solution for n was completely unique with only 1 array element
	count := 0
	for _, value := range array {
		if value == 1 {
			count++
		}
	}

	return count
}

func main() {
	// convert the command line argument to an integer
	var input int
	var err error
	input, err = strconv.Atoi(os.Args[1])
	if err != nil {
		// if there's an error in conversion, print it and exit
		panic(err)
	}
	result := compute(input)
	fmt.Printf("%d\n", result)
}
