import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class BonAppetitKtTest{
    @Test
    fun `should return proper output for example 0`() {
        val overcharge = overcharge(listOf(3, 10, 2, 9), 12, 1)

        Assertions.assertThat(overcharge).isEqualTo(5)
    }

    @Test
    fun `should return proper output for example 1`() {
        val overcharge = overcharge(listOf(3, 10, 2, 9), 7, 1)

        Assertions.assertThat(overcharge).isEqualTo(0)
    }
}