import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MainTest {

    @Test fun `Is parseArguments not allowing more arguments than needed`() {
        val emptyArgs = emptyArray<String>()
        val fulfilledArgs = arrayOf("Test", "Test")

        assertTrue(parseArguments(emptyArgs).isFailure)
        assertTrue(parseArguments(fulfilledArgs).isFailure)
    }

    @Test fun `Is parseArguments not allowing non-number string`() {
        val alphanumericArgs = arrayOf("Test")

        assertTrue(parseArguments(alphanumericArgs).isFailure)
    }

    @Test fun `Is parseArguments returning number`() {
        val numericArgs = arrayOf("1")

        assertEquals(1, parseArguments(numericArgs).getOrNull())
    }

    @Test fun `Is program running`() {
        main(arrayOf("1"))
    }

}
