package extension

import kotlin.math.sqrt

fun Number.fibonacciNumber(): Long = (2L until this.toLong())
    .fold(1L to 1L) { (prev, curr), _ ->
        curr to (prev + curr)
    }
    .second

fun Number.nextPrime(): Long = this.toLong().let { longValue ->
    generateSequence(longValue + 1L) { it + 1L }.find { it.isPrime() }!!
}

fun Number.isPrime(): Boolean {
    val longValue = this.toLong()
    val sqrt = sqrt(this.toDouble()).toLong()

    return (2L..sqrt).none { longValue % it == 0L }
}
