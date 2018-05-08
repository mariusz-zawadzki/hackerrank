import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class HurdleRaceKtTest{
    @Test
    fun `should satisfy example 0`() {
        val hurdleDiff = getHurdleDiff(listOf(1, 6, 3, 5, 2), 4)

        Assertions.assertThat(hurdleDiff).isEqualTo(2)
    }
}