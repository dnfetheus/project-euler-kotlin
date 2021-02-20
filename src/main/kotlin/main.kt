import handler.ProblemHandler
import java.lang.NumberFormatException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
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
            println("Argument isn't a number")
            null
        }
        else -> println("Must pass a number as the problem").let { null }
    }
}

