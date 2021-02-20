package problem

import extension.mapWhile

// TODO: Unsigned Int
class Problem2 : Problem<Int> {

    override val problemName = "Even Fibonacci numbers"

    override fun solve(): Int = (1..Int.MAX_VALUE)
        .mapWhile(
            { fibonacciNumber(it) },
            { it <= 4000000 }
        )
        .filter { it % 2 == 0 }
        .sum()

    fun fibonacciNumber(n: Int): Int {
        var a = 0
        var b = 1
        var temp: Int

        if (n < 1) return a

        return (2..n)
            .forEach { _ ->
                temp = a + b
                a = b
                b = temp
            }
            .let { b }
    }
}
