import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.AnnotationSpec
import io.mockk.every
import io.mockk.mockkStatic

class MainTest : AnnotationSpec() {

    @BeforeClass
    fun `Prepare tests`() {
        mockkStatic("MainKt")
        every { exitWithError() } throws Exception()
    }

    @Test
    fun `Is program not allowing an invalid number of arguments`() {
        shouldThrowAny { main(emptyArray()) }
        shouldThrowAny { main(arrayOf("1", "1")) }
    }

    @Test
    fun `Is program not allowing non-number string`() {
        shouldThrowAny { main(arrayOf("Test")) }
    }

    @Test
    fun `Is program running`() {
        shouldNotThrowAny { main(arrayOf("1")) }
    }

}
