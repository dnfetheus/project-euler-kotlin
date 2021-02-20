package handler

import mu.KotlinLogging
import problem.*
import kotlin.reflect.full.createInstance

// TODO: Unsigned short
class ProblemHandler(number: Short) {

    companion object {
        private val logger = KotlinLogging.logger { }
        private val problems = listOf(Problem1::class, Problem2::class, Problem3::class)
    }

    private val problem: Problem<out Any>

    init {
        if (number !in 1..problems.size) {
            throw Exception("Problem doesn't exist")
        }

        problem = problems[number - 1].createInstance()
    }

    fun execute() {
        logger.info { "Solving problem \"${problem.problemName}\"" }

        val start = System.currentTimeMillis()
        val result = problem.solve()
        val end = System.currentTimeMillis()
        val time = end - start

        logger.info { "Problem \"${problem.problemName}\" solved" }
        logger.info { "The result given was $result" }
        logger.info { "It took $time milliseconds to be solved" }
    }

}
