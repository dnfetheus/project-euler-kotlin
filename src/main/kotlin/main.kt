import handler.ProblemHandler
import mu.KotlinLogging
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.core.config.Configurator
import java.lang.NumberFormatException
import kotlin.system.exitProcess

val logger = KotlinLogging.logger { }

fun main(args: Array<String>) {
    Configurator.setRootLevel(Level.INFO)
    val number = parseArguments(args) ?: exitProcess(1)
    val handler = ProblemHandler(number)
    handler.execute()
}

// TODO: Unsigned short
fun parseArguments(args: Array<String>): Short? {
    return when(args.size) {
        1 -> try {
            args[0].toShort()
        } catch (e: NumberFormatException) {
            logger.info { "Argument isn't a number" }
            null
        }
        else -> logger.info { "Must pass a number as the problem" }.let { null }
    }
}

