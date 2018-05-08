import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class PickingNumbersKtTest {
    @Test
    fun `should satisfy example 0`() {
        val findLongestMinimalSubset = findLongestMinimalSubset(listOf(4, 6, 5, 3, 3, 1))

        Assertions.assertThat(findLongestMinimalSubset).isEqualTo(3)
    }

    @Test
    fun `should satisfy example 1`() {
        val findLongestMinimalSubset = findLongestMinimalSubset(listOf(1,2,2,3,1,2))

        Assertions.assertThat(findLongestMinimalSubset).isEqualTo(5)
    }

    @Test
    fun `should satisfy test case #6`() {
        val findLongestMinimalSubset = findLongestMinimalSubset(listOf(66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66))

        Assertions.assertThat(findLongestMinimalSubset).isEqualTo(100)
    }
    @Test
    fun `should satisfy test case #7`() {
        val findLongestMinimalSubset = findLongestMinimalSubset(listOf(4,97,5,97,97,4,97,4,97,97,97,97,4,4,5,5,97,5,97,99,4,97,5,97,97,97,5,5,97,4,5,97,97,5,97,4,97,5,4,4,97,5,5,5,4,97,97,4,97,5,4,4,97,97,97,5,5,97,4,97,97,5,4,97,97,4,97,97,97,5,4,4,97,4,4,97,5,97,97,97,97,4,97,5,97,5,4,97,4,5,97,97,5,97,5,97,5,97,97,97))

        Assertions.assertThat(findLongestMinimalSubset).isEqualTo(50)
    }
}