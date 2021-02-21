package problem

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem1Test: ProblemTest {

    override val problem = Problem1()

    @Test override fun `Is problem being solved correctly`() {
        assertEquals(233168, problem.solve())
    }

}
