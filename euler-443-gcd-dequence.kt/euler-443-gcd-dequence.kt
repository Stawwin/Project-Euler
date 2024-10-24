class EulerProblem {
    // calculates the greatest common divisor (GCD) of two numbers
    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    // recursively calculates g(n) based on the problem statement
    private fun g(n: Int): Int {
        return if (n == 4) {
            13
        } else {
            val prevG = g(n - 1)
            prevG + gcd(n, prevG)
        }
    }

    // solves the Euler problem for a given value of n
    fun solveEulerProblem(n: Int): Int {
        return g(n)
    }
}

fun main(args: Array<String>) {
    // Check if there is an argument provided
    if (args.size != 1) {
        println("Usage: kotlin MainKt <n>")
        return
    }

    // Convert the argument to an integer
    val n = args[0].toIntOrNull()
    if (n == null || n <= 0) {
        println("Invalid input. Please provide a valid positive integer for n.")
        return
    }

    val eulerProblem = EulerProblem()
    val result = eulerProblem.solveEulerProblem(n)
    println("$result")
}
