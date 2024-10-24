import java.util.Scanner

// class encapsulating the series calculation logic
class SeriesCalculator {
    private var a1: Int = 1
    private var a2: Int = 2
    private var a3: Int = 4
    private var a4: Int = 8

    // compute the nth term in the series
    fun compute(y: Int): Int {
        var an: Int = 0
        for (x in 0 until y - 4) {
            an = a1 + a2 + a3 + a4
            // update the values of the terms for the next iteration
            a1 = a2
            a2 = a3
            a3 = a4
            a4 = an
        }
        return an
    }
}

fun main(args: Array<String>) {
    val seriesCalculator = SeriesCalculator()

    while (true) {

        try {
            // get user input and compute the series using the SeriesCalculator class
            val input = args[0].toInt()
            println(seriesCalculator.compute(input))
            break
        } catch (e: java.util.InputMismatchException) {
            // display an error message for invalid input and continue the loop
            println("Invalid input. Please enter a valid integer.")
            continue
        }
    }

}
