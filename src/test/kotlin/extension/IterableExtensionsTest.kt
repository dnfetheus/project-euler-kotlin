package extension

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class IterableExtensionsTest : StringSpec({

    val values = listOf("Subaru", "DeepFuckingValue", "yee", "Test")

    "Is mapWhile accurate" {
        values.mapWhile({ it.toUpperCase() }, { it != "TEST" }) shouldHaveSize 3
    }

})
