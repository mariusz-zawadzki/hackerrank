import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class DivisibleSumPairsKtTest{

    @Test
    fun `should return 0 for empty list`() {
        val countDivisiblePairs = countDivisiblePairs(arrayListOf(), 1)

        Assertions.assertThat(countDivisiblePairs).isZero()
    }
    @Test
    fun `should return 3 for example list`() {
        val countDivisiblePairs = countDivisiblePairs(arrayListOf(1,3,2,6,1,2), 3)

        Assertions.assertThat(countDivisiblePairs).isEqualTo(5)
    }
}