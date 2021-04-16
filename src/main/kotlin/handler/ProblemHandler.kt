package handler

import mu.KotlinLogging
import problem.Problem
import kotlin.reflect.full.createInstance

private val logger = KotlinLogging.logger {}

class ProblemHandler(number: Short) {

    private val problem: Problem<Any>

    init {
        val result = runCatching { Class.forName("problem.Problem$number") }
        val clazz = result.getOrElse { throw IllegalArgumentException("Problem doesnt't exist") }
        problem = clazz.kotlin.createInstance() as Problem<Any>
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
