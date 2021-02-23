package problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeExactly

class Problem2Test : StringSpec({

    val problem = Problem2()

    "Is fibonacciNumber accurate" {
        forAll(
            row(1, 1),
            row(2, 1),
            row(3, 2),
            row(7, 13)
        ) { a, b ->
            Problem2.fibonacciNumber(a) shouldBeExactly b
        }
    }

    "Is problem being solved correctly" {
        problem.solve() shouldBeExactly 4613732
    }

})
