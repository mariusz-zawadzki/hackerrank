import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class Three_D_SurfaceKtTest{
    @Test
    fun `should properly calculate surface for example`() {
        val input = arrayOf(
                arrayOf(1, 3, 4),
                arrayOf(2, 2, 3),
                arrayOf(1, 2, 4)
        )
        val surfaceArea = surfaceArea(input, 3, 3)
        Assertions.assertThat(surfaceArea).isEqualTo(60)
    }

    @Test
    fun `should properly calculate surface for example0`() {
        val input = arrayOf(
                arrayOf(1)
        )
        val surfaceArea = surfaceArea(input, 1, 1)
        Assertions.assertThat(surfaceArea).isEqualTo(6)
    }
}