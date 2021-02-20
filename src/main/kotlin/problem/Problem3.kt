package problem

// TODO: Unsigned Long
class Problem3 : Problem<Long> {

    override val problemName = "Largest prime factor"

    private val number = 600851475143L

    override fun solve(): Long = largestPrimeFactor(number)

    fun largestPrimeFactor(n: Long): Long {
        var largestFactor = 1L
        var temp = n

        while (temp != 1L) {
            while ((temp % largestFactor != 0L).or(largestFactor == 1L)) {
                largestFactor = nextPrime(largestFactor)
            }

            temp /= largestFactor
        }

        return largestFactor
    }

    fun nextPrime(n: Long): Long = (n + 1L..Long.MAX_VALUE)
        .find { isPrime(it) }!!

    fun isPrime(n: Long): Boolean = (2L..n/2L)
        .none { n % it == 0L }

}
