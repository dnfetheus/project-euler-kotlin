package problem

import extension.primeFactors

class Problem3 : Problem<Long> {

    override val problemName = "Largest prime factor"

    private val number = 600851475143L

    override fun solve(): Long = number.primeFactors().last()

}
