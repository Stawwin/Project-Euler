import kotlin.math.floor

// defining a solution counter
interface SolutionCounter {
    fun compute(): Int
}

// implements common functionality for solution counting
open class SolutionCounterBase(val limit: Int) : SolutionCounter {

    // stores the counts for each 'n'
    protected val array = IntArray(limit)

    // computes and counts possible solutions
    override fun compute(): Int {
        for (a in 1 until limit) {
            for (d in (floor(a.toDouble() / 4.0) + 1).toInt() until a) {
                val n = a * (4 * d - a)
                if (n > limit - 1) {
                    break
                } else {
                    array[n]++
                }
            }
        }

        // counts how many times the solution for 'n' was completely unique with only 1 array element.
        var count = 0
        for (value in array) {
            if (value == 1) {
                count++
            }
        }

        return count
    }
}


// Function demonstrating polymorphism by accepting any object that implements SolutionCounter interface
fun executeSolutionCounter(solutionCounter: SolutionCounter) {
    val result = solutionCounter.compute()
    println("$result")
}

fun main(args: Array<String>) {
	// Read the input from the command line
	val input = args[0].toInt()
    val solutionCounter: SolutionCounter = SolutionCounterBase(input)
    executeSolutionCounter(solutionCounter)
}
