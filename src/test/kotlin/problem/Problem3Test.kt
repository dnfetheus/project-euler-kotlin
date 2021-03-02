package problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe

class Problem3Test : StringSpec({

    val problem = Problem3()

    "Is problem being solved correctly" {
        problem.solve() shouldBeExactly 6857L
    }

})
