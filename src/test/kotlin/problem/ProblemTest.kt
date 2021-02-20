package problem

interface ProblemTest {

    val problem: Problem<out Any>

    fun `Is problem being solved correctly`()

}
