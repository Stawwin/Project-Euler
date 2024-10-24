class CuboidRouteCalculator(private var a: Int, private var b: Int) {

    // finds the minimum value of M that satisfies the given condition
    fun findMinimumM(seek: Int): Int {
        while (b - a > 1) {
            val c = (b + a) / 2
            if (calculateRoutes(c) >= seek) {
                b = c
            } else {
                a = c
            }
        }
        return b
    }

    // calculates the total number of routes for a given M using the Euclidean algorithm
    private fun calculateRoutes(M: Int): Int {
        var total = 0
        val maxM = M
        for (n in 1 until maxM) {
            for (m in n + 1 until maxM step 2) {
                if (gcd(m, n) == 1) {
                    val (a, b) = sort(m * m - n * n, 2 * m * n)
                    for (k in 1..(M / b)) {
                        total += (a * k) / 2
                    }
                    if (2 * a >= b) {
                        for (k in 1..(M / a)) {
                            total += ((2 * a * k) - (b * k) + 2) / 2
                        }
                    }
                }
            }
        }
        return total
    }

    // finds the greatest common divisor using the Euclidean algorithm
    private fun gcd(a: Int, b: Int): Int {
        var tempA = a
        var tempB = b
        while (tempB != 0) {
            val temp = tempA
            tempA = tempB
            tempB = temp % tempB
        }
        return tempA
    }

    // sorts two integers and returns them as a Pair
    private fun sort(a: Int, b: Int): Pair<Int, Int> {
        return if (a < b) Pair(a, b) else Pair(b, a)
    }
}

fun main(args: Array<String>) {
    // check if there is an argument provided
    if (args.size != 1) {
        println("Usage: kotlin MainKt <seek>")
        return
    }

    // convert the argument to an integer
    val seek = args[0].toIntOrNull()
    if (seek == null || seek <= 0) {
        println("Invalid input. Please provide a valid positive integer for seek.")
        return
    }

    val cuboidRouteCalculator = CuboidRouteCalculator(2, 10000)
    val result = cuboidRouteCalculator.findMinimumM(seek)
    println(result)
}
