import org.assertj.core.api.Assertions
import org.junit.Test

class Absolute_PermutationsKtTest {

    @Test
    fun `should satisfy example from description`() {
        val absolutePermutation = absolutePermutation(4, 2)

        Assertions.assertThat(absolutePermutation).isEqualTo(listOf(3, 4, 1, 2))
    }

    @Test
    fun `should satisfy example from sample 0`() {
        val absolutePermutation = absolutePermutation(2, 1)

        Assertions.assertThat(absolutePermutation).containsExactly(2, 1)
    }

    @Test
    fun `should satisfy example from sample 0 1`() {
        val absolutePermutation = absolutePermutation(3, 0)

        Assertions.assertThat(absolutePermutation).containsExactly(1, 2, 3)
    }

    @Test
    fun `should satisfy example from sample 0 2`() {
        val absolutePermutation = absolutePermutation(3, 2)

        Assertions.assertThat(absolutePermutation).containsExactly(-1)
    }
}