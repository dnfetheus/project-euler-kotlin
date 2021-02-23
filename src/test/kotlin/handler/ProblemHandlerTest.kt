package handler

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec


class ProblemHandlerTest : StringSpec({

    "Is constructor handling error" {
        shouldThrowAny { ProblemHandler(0) }
    }

    "Is handler solving problem" {
        shouldNotThrowAny { ProblemHandler(1).execute() }
    }

})
