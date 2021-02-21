import handler.ProblemHandler
import mu.KotlinLogging
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.core.config.Configurator
import kotlin.system.exitProcess

val logger = KotlinLogging.logger { }

fun main(args: Array<String>) {
    Configurator.setRootLevel(Level.INFO)
    parseArguments(args).fold(
        { ProblemHandler(it).execute() },
        { logger.error { it.message }.also { exitProcess(1) } }
    )
}

fun parseArguments(args: Array<String>): Result<Short> {
    return when(args.size) {
        1 -> runCatching { args[0].toShort() }
        else -> return Result.failure(Exception("No argument given"))
    }
}

