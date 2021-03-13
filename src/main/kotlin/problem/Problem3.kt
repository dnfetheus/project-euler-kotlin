package problem

import extension.nextPrime

class Problem3 : Problem<Long> {

    override val problemName = "Largest prime factor"

    private val number = 600851475143L

    override fun solve(): Long {
        var temp = number
        var factor = 2L

        while (temp != 1L) {
            while (temp % factor != 0L) {
                factor = factor.nextPrime()
            }

            temp /= factor
        }

        return factor
    }

}
