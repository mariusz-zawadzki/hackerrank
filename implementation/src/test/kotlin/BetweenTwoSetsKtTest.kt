import org.junit.Test
import org.assertj.core.api.Assertions.*

class BetweenTwoSetsKtTest {

    @Test
    fun `should find proper number of divisors`() {
        val a= arrayOf(2,4)
        val b= arrayOf(16,32,96)
        val totalX = getTotalX(a, b)

        assertThat(totalX).isEqualTo(3)
    }

}