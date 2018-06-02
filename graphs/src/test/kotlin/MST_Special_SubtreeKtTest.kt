import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test
import java.io.StringReader
import java.util.*

class MST_Special_SubtreeKtTest{

    @Test
    fun `satisfiece example`() {
        val input = """
            5 6
            1 2 3
            1 3 4
            4 2 6
            5 2 2
            2 3 5
            3 5 7
            1
            """.trimIndent()
        val output = 15
        val result = primsFullInput(Scanner(StringReader(input)))

        Assertions.assertThat(result).isEqualTo(output)
    }
}