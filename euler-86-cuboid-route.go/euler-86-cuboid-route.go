package main

import (
	"fmt"
	"os"
	"strconv"
)

// gcd calculates the greatest common divisor using the Euclidean algorithm
func gcd(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}

// sort returns two integers in ascending order
func sort(a, b int) (int, int) {
	if a < b {
		return a, b
	}
	return b, a
}

// routes calculates the total number of routes for a given parameter M
func routes(M int) (total int) {
	maxm := M
	for n := 1; n < maxm; n++ {
		for m := n + 1; m < maxm; m += 2 {
			if gcd(m, n) == 1 {
				a := m*m - n*n
				b := 2 * m * n
				a, b = sort(a, b)
				for k := 1; k*b <= M; k++ {
					total += (a * k) / 2
				}
				if 2*a >= b {
					for k := 1; k*a <= M; k++ {
						total += ((2 * a * k) - (b * k) + 2) / 2
					}
				}
			}
		}
	}
	return
}

func main() {
	var input int
	var err error
	input, err = strconv.Atoi(os.Args[1]) // input from command line
	if err != nil {
		// if there is conversion to integer error, exit
		panic(err)
	}
	a, b := 2, 10000
	// Binary search to find the minimum parameter value that satisfies the condition
	for b-a > 1 {
		c := (b + a) / 2
		if routes(c) >= input {
			b = c
		} else {
			a = c
		}
	}
	fmt.Println(b)
}
