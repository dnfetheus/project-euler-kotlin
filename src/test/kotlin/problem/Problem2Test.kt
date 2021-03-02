package problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.longs.shouldBeExactly

class Problem2Test : StringSpec({

    val problem = Problem2()

    "Is problem being solved correctly" {
        problem.solve() shouldBeExactly 4613732L
    }

})
