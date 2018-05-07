import org.assertj.core.api.Assertions
import org.junit.Test

class MinDivosorsTest {

    @Test
    fun `should find minimal common greatest dividers of 15, 30, 45, 90`() {

        val findMinDivider = findMinDivider(arrayOf(15, 30, 45, 90))

        Assertions.assertThat(findMinDivider).isEqualTo(15)
    }

    @Test
    fun `should find minimal common greatest dividers of 32, 16, 64, 104`() {

        val findMinDivider = findMinDivider(arrayOf(32, 16, 64, 104))

        Assertions.assertThat(findMinDivider).isEqualTo(8)
    }
}