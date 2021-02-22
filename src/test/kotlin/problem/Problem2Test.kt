package problem

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Problem2Test : ProblemTest {

    override val problem = Problem2()

    @Test fun `Is fibonacciNumber accurate`() {
        assertEquals(1, Problem2.fibonacciNumber(1))
        assertEquals(1, Problem2.fibonacciNumber(2))
        assertEquals(2, Problem2.fibonacciNumber(3))
        assertEquals(13, Problem2.fibonacciNumber(7))
    }

    @Test override fun `Is problem being solved correctly`() {
        assertEquals(4613732, problem.solve())
    }

}
