package handler

import constant.PROBLEMS
import mu.KotlinLogging
import problem.Problem
import kotlin.reflect.full.createInstance

private val logger = KotlinLogging.logger {}

class ProblemHandler(number: Short) {

    private val problem: Problem<Any>

    init {
        when (number) {
            in 1..PROBLEMS.size -> problem = PROBLEMS.last().createInstance()
            else -> throw Exception("Problem doesn't exist")
        }
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
