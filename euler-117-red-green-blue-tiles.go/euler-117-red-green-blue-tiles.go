package main

import (
	"fmt"
	"os"
	"strconv"
)

// compute the nth term in the series
func compute(y int) int {
    a1 := 1
    a2 := 2
    a3 := 4
    a4 := 8

    var an int
    for x := 0; x < y-4; x++ {
        an = a1 + a2 + a3 + a4
        // update the values of the terms for the next iteration
        a1, a2, a3, a4 = a2, a3, a4, an
    }

    return an
}

func main() {
	var input int
	var err error
	input, err = strconv.Atoi(os.Args[1]) // input from command line
	if err != nil {
		// if there is conversion to integer error, exit
		panic(err)
	}
        // compute and print the result for the desired integer
        fmt.Println(compute(input))
    }

// Note: The numbers being dealt with are too big for kotlin and we are give a stack overflow.
// The algoritm works just fine, and is correct for smaller inputs.
