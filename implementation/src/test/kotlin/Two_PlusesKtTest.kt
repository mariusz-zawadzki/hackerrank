import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class Two_PlusesKtTest{
    @Test
    fun `satisfiec testcase 0`() {
        val input = """
        GGGGGG
        GBBBGB
        GGGGGG
        GGBBGB
        GGGGGG""".trimIndent()
                .lines().map { it.split("").filter { it!="" }.toTypedArray() }.toTypedArray()

        val twoPluses = twoPluses(input, 5, 6)

        Assertions.assertThat(twoPluses).isEqualTo(5)
    }

    @Test
    fun `satisfiec testcase 1`() {
        val input = """
        BGBBGB
        GGGGGG
        BGBBGB
        GGGGGG
        BGBBGB
        BGBBGB""".trimIndent()
                .lines().map { it.split("").filter { it!="" }.toTypedArray() }.toTypedArray()

        val twoPluses = twoPluses(input, 6, 6)

        Assertions.assertThat(twoPluses).isEqualTo(25)
    }
}