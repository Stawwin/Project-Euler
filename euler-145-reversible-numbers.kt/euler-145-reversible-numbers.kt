// creates a class to encapsulate number-related functionality
class NumberProcessor {
    // checks if a number is odd by examining its digits
    fun isOdd(n: Int): Boolean {
        val a = n.toString()
        for (i in 0 until a.length) {
            val x = a[i].toString().toInt()
            if (x % 2 == 0) {
                return false
            }
        }
        return true
    }

    // reverses the digits of a given number
    fun intReverse(n: Int): Int {
        var reversed = 0
        var number = n
        while (number != 0) {
            reversed = reversed * 10 + number % 10
            number /= 10
        }
        return reversed
    }
}

fun main(args: Array<String>) {
    // Check if there is an argument provided
    if (args.size != 1) {
        println("Usage: kotlin MainKt <upperLimit>")
        return
    }

    // Convert the argument to an integer
    val upperLimit = args[0].toIntOrNull()
    if (upperLimit == null || upperLimit <= 0) {
        println("Invalid input. Please provide a valid positive integer for the upper limit.")
        return
    }

    // creates an instance of the NumberProcessor class
    val numberProcessor = NumberProcessor()
    // initialize a variable to count the total occurrences
    var total = 0
    // loops through numbers from 0 to the specified upper limit
    for (i in 0 until upperLimit) {
        // checks if the sum of the number and its reverse is odd,
        // and if the last digit of the original number is not 0
        if (numberProcessor.isOdd(i + numberProcessor.intReverse(i)) && i % 10 != 0) {
            // increment the total count
            total++
        }
    }
    // print the total count of occurrences
    println(total)
}
