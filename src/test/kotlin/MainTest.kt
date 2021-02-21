import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MainTest {

    @Test fun `Is parseArguments not allowing more arguments than needed`() {
        val emptyArgs = emptyArray<String>()
        val fulfilledArgs = arrayOf("Test", "Test")

        assertNull(parseArguments(emptyArgs))
        assertNull(parseArguments(fulfilledArgs))
    }

    @Test fun `Is parseArguments not allowing non-number string`() {
        val alphanumericArgs = arrayOf("Test")

        assertNull(parseArguments(alphanumericArgs))
    }

    @Test fun `Is parseArguments returning number`() {
        val numericArgs = arrayOf("1")

        assertEquals(1, parseArguments(numericArgs)!!)
    }

    @Test fun `Is program running`() {
        main(arrayOf("1"))
    }

}
