package problem

import extension.mapWhile

class Problem2 : Problem<Int> {

    companion object {
        fun fibonacciNumber(n: Int): Int {
            var a = 0
            var b = 1

            return when (n < 1) {
                true -> a
                else -> (2..n)
                    .forEach { _ ->
                        val temp = a + b
                        a = b
                        b = temp
                    }
                    .let { b }
            }
        }
    }

    override val problemName = "Even Fibonacci numbers"

    override fun solve(): Int = (1..Int.MAX_VALUE)
        .mapWhile(
            { fibonacciNumber(it) },
            { it <= 4000000 }
        )
        .filter { it % 2 == 0 }
        .sum()
}
