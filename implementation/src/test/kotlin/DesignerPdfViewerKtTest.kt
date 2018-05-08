import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class DesignerPdfViewerKtTest{


    @Test
    fun `should satisfy example 0`() {
        val lettersInput = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5"
        val letterHeights = parseInput(lettersInput)

        val selectionArea = getSelectionArea("abc", letterHeights)

        Assertions.assertThat(selectionArea).isEqualTo(9)
    }

    @Test
    fun `should satisfy example 1`() {
        val lettersInput = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7"
        val letterHeights = parseInput(lettersInput)

        val selectionArea = getSelectionArea("zaba", letterHeights)

        Assertions.assertThat(selectionArea).isEqualTo(28)
    }

    private fun parseInput(lettersInput: String): Map<Char, Int> {
        val letters = lettersInput.split(" ").map { it.trim().toInt() }
        val letterHeights = ('a'..'z').zip(letters).toMap()
        return letterHeights
    }
}