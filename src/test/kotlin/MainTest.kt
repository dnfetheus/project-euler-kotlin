import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MainTest : StringSpec({

    "Is parseArguments not allowing more arguments than needed" {
        parseArguments(emptyArray()).isFailure shouldBe true
        parseArguments(arrayOf("Test", "Test")).isFailure shouldBe true
    }

    "Is parseArguments not allowing non-number string" {
        parseArguments(arrayOf("Test")).isFailure shouldBe true
    }

    "Is parseArguments returning number" {
        parseArguments(arrayOf("1")).getOrNull() shouldBe 1
    }

    "Is program running" {
        shouldNotThrowAny { main(arrayOf("1")) }
    }

})
