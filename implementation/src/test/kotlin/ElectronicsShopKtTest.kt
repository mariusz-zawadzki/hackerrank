import org.assertj.core.api.Assertions
import org.junit.Test

class ElectronicsShopKtTest {
    @Test
    fun `should satisfy example 0`() {
        val moneySpent = getMoneySpent(listOf(3, 1), listOf(5, 2, 8), 10)

        Assertions.assertThat(moneySpent).isEqualTo(9)
    }

    @Test
    fun `should satisfy example 1`() {
        val moneySpent = getMoneySpent(listOf(4), listOf(5), 5)

        Assertions.assertThat(moneySpent).isEqualTo(-1)
    }

    @Test
    fun `should find proper max spendings`() {
        val moneySpent = getMoneySpent(listOf(4, 12, 33, 25), listOf(1, 24, 26, 27, 17), 50)

        Assertions.assertThat(moneySpent).isEqualTo(50)
    }
}