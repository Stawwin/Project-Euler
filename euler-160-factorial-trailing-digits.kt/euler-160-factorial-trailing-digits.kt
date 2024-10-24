import java.math.BigInteger

// Class encapsulating the functionality to calculate the factorial
class FactorialCalculator {
    // Variable to store the result of the factorial calculation
    private var result = BigInteger.ONE

    // Private method to remove trailing zeroes from the result
    private fun removeTrailingZeroes() {
        while (result.mod(BigInteger.TEN) == BigInteger.ZERO) {
            result = result.divide(BigInteger.TEN)
        }
    }

    // Method to calculate the factorial of a given BigInteger N
    fun calculateFactorial(N: BigInteger) {
        result = BigInteger.ONE
        var i = BigInteger.ONE

        // Calculate the factorial of N
        while (i <= N) {
            result = result.multiply(i)
            removeTrailingZeroes()
            i = i.add(BigInteger.ONE)
        }
    }

    // Method to get the last five digits of the calculated factorial
    fun getLastFiveDigits(): Int {
        // Extract the last five digits
        return result.mod(BigInteger.TEN.pow(5)).toInt()
    }
}

fun main(args: Array<String>) {
    // Get the input from the command line
    val input = args[0]
    // Create an instance of the FactorialCalculator class
    val factorialCalculator = FactorialCalculator()
    val N = BigInteger(input) // Set the desired value of N

    // Calculate the factorial and print the result
    factorialCalculator.calculateFactorial(N)
    val result = factorialCalculator.getLastFiveDigits()
    println(result)
}
