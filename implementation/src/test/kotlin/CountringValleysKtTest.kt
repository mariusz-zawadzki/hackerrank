import org.assertj.core.api.Assertions
import org.junit.Test

class CountringValleysKtTest {
    @Test
    fun `should satisfy example 0`() {
        val countValeys = countValeys("UDDDUDUU")

        Assertions.assertThat(countValeys).isEqualTo(1)
    }

    @Test
    fun `should properly count 3 valleys`() {
        val countValeys = countValeys("UDDDUDUUUDDUUDDDUUUU")

        Assertions.assertThat(countValeys).isEqualTo(3)
    }
}