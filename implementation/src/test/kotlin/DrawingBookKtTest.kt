import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class DrawingBookKtTest{
    @Test
    fun `should return zero for first page`() {
        val pageCount = pageCount(10, 1)

        Assertions.assertThat(pageCount).isZero()
    }

    @Test
    fun `should return zero for last page`() {
        val pageCount = pageCount(10, 10)

        Assertions.assertThat(pageCount).isZero()
    }
    @Test
    fun `should satisfy example 0`() {
        val pageCount = pageCount(6, 2)

        Assertions.assertThat(pageCount).isEqualTo(1)
    }

    @Test
    fun `should satisfy example 1`() {
        val pageCount = pageCount(5, 4)

        Assertions.assertThat(pageCount).isEqualTo(0)
    }
    @Test
    fun `should satisfy test case 26`() {
        val pageCount = pageCount(6, 5)

        Assertions.assertThat(pageCount).isEqualTo(1)
    }
}