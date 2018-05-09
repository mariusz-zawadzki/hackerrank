import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class NonDivisibleSubsetKtTest{
    @Test
    fun `should satisfy example`() {
        val nonDivisibleSubset = nonDivisibleSubset(3, listOf<Int>(1, 7, 2, 4))

        Assertions.assertThat(nonDivisibleSubset).isEqualTo(3)
    }

    @Test
    fun `should different set`() {
        val nonDivisibleSubset = nonDivisibleSubset(3, listOf<Int>(1, 9, 2, 4))

        Assertions.assertThat(nonDivisibleSubset).isEqualTo(3)
    }

    @Test
    fun `should different set 1924`() {
        val nonDivisibleSubset = nonDivisibleSubset(4, listOf<Int>(1, 9, 2, 4))

        Assertions.assertThat(nonDivisibleSubset).isEqualTo(4)
    }

    @Test
    fun `should different set 1 to 10`() {
        val nonDivisibleSubset = nonDivisibleSubset(4, listOf<Int>(1,2,3,4,5,6,7,8,9,10))

        Assertions.assertThat(nonDivisibleSubset).isEqualTo(5)
    }
}