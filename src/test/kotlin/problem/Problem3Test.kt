package problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe

class Problem3Test : StringSpec({

    val primeNumbers = listOf<Long>(1, 2, 3, 5, 7, 11, 13, 17, 19, 23)
    val nonPrimeNumbers = listOf<Long>(4, 6, 8, 9, 10, 12, 14, 15, 16, 18)

    val problem = Problem3()

    "Is isPrime returning true for prime numbers" {
        primeNumbers.all { Problem3.isPrime(it) } shouldBe true
    }

    "Is isPrime returning false for non prime numbers" {
        nonPrimeNumbers.none { Problem3.isPrime(it) } shouldBe true
    }

    "Is nextPrime returning the next prime" {
        Problem3.nextPrime(12L) shouldBeExactly 13L
    }

    "Is largestPrimeFactor accurate" {
        Problem3.primeFactors(33L) shouldBe listOf(3L, 11L)
        Problem3.primeFactors(13195L) shouldBe listOf(5L, 7L, 13L, 29L)
    }

    "Is problem being solved correctly" {
        problem.solve() shouldBeExactly 6857L
    }

})
