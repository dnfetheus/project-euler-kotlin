package extension

import kotlin.math.sqrt

fun Number.fibonacciNumber(): Long {
    // This (creates overhead)
//    fun fibonacciSequence(term: Long): Long {
//        var a = 0L
//        var b = 1L
//
//        return (2L..term)
//            .forEach { _ ->
//                val temp = a + b
//                a = b
//                b = temp
//            }
//            .let { b }
//    }

    // Or

    val fibonacciSequence = { term: Long ->
        var a = 0L
        var b = 1L

        (2L..term)
            .forEach { _ ->
                val temp = a + b
                a = b
                b = temp
            }
            .let { b }
    }

    val longValue = this.toLong()

    return when {
        longValue < 1 -> 0
        else -> fibonacciSequence(longValue)
    }
}

fun Number.primeFactors(): List<Long> {
    val longValue = this.toLong()

    val findPrimeFactors = { number: Long ->
        val factors = mutableListOf<Long>()
        var factor = 2L
        var temp = number

        while (temp != 1L) {
            while (temp % factor != 0L) {
                factor = factor.nextPrime()
            }

            factors.add(factor)
            temp /= factor
        }

        factors
    }

    return when {
        isPrime() -> listOf(longValue)
        else -> findPrimeFactors(longValue)
    }
}

fun Number.nextPrime(): Long {
    val longValue = this.toLong()

    return generateSequence(longValue + 1L) { it + 1L }
        .find { it.isPrime() }!!
}

fun Number.isPrime(): Boolean {
    val longValue = this.toLong()
    val squareOfValue = sqrt(this.toDouble()).toLong()

    return (2L..squareOfValue)
        .none { longValue % it == 0L }
}

