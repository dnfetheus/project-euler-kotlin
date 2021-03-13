package extension

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe
import problem.Problem3

class NumberExtensionsTest : StringSpec({

    val primeNumbers = listOf<Long>(1, 2, 3, 5, 7, 11, 13, 17, 19, 23)
    val nonPrimeNumbers = listOf<Long>(4, 6, 8, 9, 10, 12, 14, 15, 16, 18)

    "Is fibonacciNumber accurate" {
        forAll<Long, Long>(
            row(1, 1),
            row(2, 1),
            row(3, 2),
            row(7, 13)
        ) { a, b ->
            a.fibonacciNumber() shouldBeExactly b
        }
    }

    "Is isPrime returning true for prime numbers" {
        primeNumbers.all { it.isPrime() } shouldBe true
    }

    "Is isPrime returning false for non prime numbers" {
        nonPrimeNumbers.none { it.isPrime() } shouldBe true
    }

})
