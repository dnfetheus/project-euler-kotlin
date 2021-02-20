package extension

import kotlin.test.Test
import kotlin.test.assertEquals

class IterableExtensionsTest {

    private val iterable = listOf("Subaru", "DeepFuckingValue", "yee", "Test")

    @Test
    fun `Is mapWhile accurate`() {
        val mappedIterable = iterable
            .mapWhile(
                { it.toUpperCase() },
                { it != "TEST" }
            )

        assertEquals(3, mappedIterable.size)
    }

}
