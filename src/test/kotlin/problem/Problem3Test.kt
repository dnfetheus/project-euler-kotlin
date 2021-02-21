package problem

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Problem3Test : ProblemTest {

    private val primeNumbers = listOf<Long>(1, 2, 3, 5, 7, 11, 13, 17, 19, 23)
    private val nonPrimeNumbers = listOf<Long>(4, 6, 8, 9, 10, 12, 14, 15, 16, 18)

    override val problem = Problem3()

    @Test fun `Is isPrime returning true for prime numbers`() {
        assertTrue(primeNumbers.all { problem.isPrime(it) })
    }

    @Test fun `Is isPrime returning false for non prime numbers`() {
        assertTrue(nonPrimeNumbers.none { problem.isPrime(it) })
    }

    @Test fun `Is nextPrime returning the next prime`() {
        assertEquals(13, problem.nextPrime(12))
    }

    @Test fun `Is largestPrimeFactor accurate`() {
        assertEquals(11, problem.largestPrimeFactor(33))
        assertEquals(29, problem.largestPrimeFactor(13195))
    }

    @Test override fun `Is problem being solved correctly`() {
        assertEquals(6857, problem.solve())
    }

}
