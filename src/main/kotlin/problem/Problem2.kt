package problem

import extension.fibonacciNumber

class Problem2 : Problem<Long> {

    override val problemName = "Even Fibonacci numbers"

    private val limit = 4000000L

    override fun solve(): Long = generateSequence(1) { it + 1 }
        .map { it.fibonacciNumber() }
        .takeWhile { it <= limit }
        .filter { it % 2L == 0L }
        .sum()

}
