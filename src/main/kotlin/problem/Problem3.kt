package problem

import kotlin.math.sqrt

class Problem3 : Problem<Long> {

    companion object {
        fun primeFactors(n: Long): List<Long> {
            val factors = mutableListOf<Long>()

            return when {
                isPrime(n) -> factors.add(n).let { factors }
                else -> {
                    var factor = 2L
                    var temp = n

                    while (temp != 1L) {
                        while (temp % factor != 0L) {
                            factor = nextPrime(factor)
                        }

                        factors.add(factor)
                        temp /= factor
                    }

                    factors
                }
            }
        }

        fun nextPrime(n: Long): Long = (n + 1L..Long.MAX_VALUE)
            .find { isPrime(it) }!!

        fun isPrime(n: Long): Boolean = (2L..sqrt(n.toDouble()).toLong())
            .none { n % it == 0L }
    }

    override val problemName = "Largest prime factor"

    private val number = 600851475143L

    override fun solve(): Long = primeFactors(number).let { it[it.size - 1] }

}
