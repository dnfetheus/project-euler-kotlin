package handler

import constant.PROBLEMS
import mu.KotlinLogging
import problem.Problem
import kotlin.reflect.full.createInstance

class ProblemHandler(number: Short) {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    private val problem: Problem<out Any>

    init {
        if (number !in 1..PROBLEMS.size) {
            throw Exception("Problem doesn't exist")
        }

        problem = PROBLEMS[number - 1].createInstance()
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
