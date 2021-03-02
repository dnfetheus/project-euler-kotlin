package extension

import kotlin.math.sqrt

fun Number.fibonacciNumber(): Long = (2L until this.toLong())
    .fold(1L to 1L) { (prev, curr), _ ->
        curr to (prev + curr)
    }
    .second

fun Number.primeFactors(): List<Long> {
    tailrec fun findNextPrimeFactor(value: Long, factor: Long): Long = when {
        value % factor != 0L -> findNextPrimeFactor(value, factor.nextPrime())
        else -> factor
    }

    val findPrimeFactors = { value: Long ->
        val factors = mutableListOf<Long>()
        var temp = value

        while (temp != 1L) {
            findNextPrimeFactor(temp, factors.lastOrNull() ?: 2L).let {
                factors.add(it)
            }
            temp /= factors.last()
        }

        factors
    }

    return this.toLong().let {
        when {
            it.isPrime() -> listOf(it)
            else -> findPrimeFactors(it)
        }
    }
}

fun Number.nextPrime(): Long = this.toLong().let { longValue ->
    generateSequence(longValue + 1L) { it + 1L }.find { it.isPrime() }!!
}

fun Number.isPrime(): Boolean = (this.toLong() to sqrt(this.toDouble()).toLong())
    .let { pair -> (2L..pair.second).none { pair.first % it == 0L } }
