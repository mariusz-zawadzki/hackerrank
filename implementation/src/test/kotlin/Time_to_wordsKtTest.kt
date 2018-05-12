import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class Time_to_wordsKtTest{
    @Test
    fun `should satisfy example 0`() {
        val timeInWords = timeInWords(5, 47)

        Assertions.assertThat(timeInWords).isEqualTo("thirteen minutes to six")
    }

    @Test
    fun `should satisfy example 1`() {
        val timeInWords = timeInWords(3, 0)

        Assertions.assertThat(timeInWords).isEqualTo("three o' clock")
    }

    @Test
    fun `should satisfy example 2`() {
        val timeInWords = timeInWords(7,15)

        Assertions.assertThat(timeInWords).isEqualTo("quarter past seven")
    }
}