package problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeExactly

class Problem1Test : StringSpec({

    val problem = Problem1()

    "Is problem being solved correctly" {
        problem.solve() shouldBeExactly 233168
    }

})
