import org.assertj.core.api.Assertions
import org.junit.Test

import org.junit.Assert.*

class BreakingBestAndWorstKtTest {

    @Test
    fun `should break records`() {
        val breakingRecords = breakingRecords(arrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42))

        Assertions.assertThat(breakingRecords).containsExactly(4, 0)
    }


    @Test
    fun `should break records with worst`() {
        val breakingRecords = breakingRecords(arrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1))

        Assertions.assertThat(breakingRecords).containsExactly(2, 4)
    }
}