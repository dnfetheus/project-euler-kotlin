package handler

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class ProblemHandlerTest {

    @Test
    fun `Is constructor handling error`() {
        val wrongNumber: Short = 0

        assertThrows<Exception> { ProblemHandler(wrongNumber) }
    }

    @Test
    fun `Is handler solving problem`() {
        val rightNumber: Short = 1

        assertDoesNotThrow { ProblemHandler(rightNumber).also { it.execute() } }
    }

}
