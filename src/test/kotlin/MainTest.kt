import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MainTest {

    @Test
    fun `Is parseArguments not allowing more arguments than needed`() {
        val emptyArgs = emptyArray<String>()
        val fulfilledArgs = arrayOf("Test", "Test")

        assertNull(parseArguments(emptyArgs))
        assertNull(parseArguments(fulfilledArgs))
    }

    @Test
    fun `Is parseArguments not allowing non-number string`() {
        val args = arrayOf("Test")

        assertNull(parseArguments(args))
    }

    @Test
    fun `Is parseArguments returning number`() {
        val args = arrayOf("1")

        assertEquals(1, parseArguments(args)!!)
    }

    @Test
    fun `Is program running`() {
        main(arrayOf("1"))
    }

}
