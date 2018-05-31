import org.assertj.core.api.Assertions
import org.junit.Test

class CrossTest {

    @Test
    fun `same center crosses overlap`() {
        val plus1 = Cross(1,2,2)
        val plus2 = Cross(1,2,2)

        val overlaps = plus1.overlaps(plus2)

        Assertions.assertThat(overlaps).isTrue()
    }

    @Test
    fun `different center crosses with size 1 do not overlap`() {
        val plus1 = Cross(1,2,2)
        val plus2 = Cross(1,2,3)

        val overlaps = plus1.overlaps(plus2)

        Assertions.assertThat(overlaps).isFalse()
    }

    @Test
    fun `overlaping is symetric`() {
        val plus1 = Cross(1,2,2)
        val plus2 = Cross(1,2,3)

        val overlaps = plus1.overlaps(plus2)

        Assertions.assertThat(overlaps).isEqualTo(plus2.overlaps(plus1))
    }

    @Test
    fun `crosses with size 3 overlap if they are side by side'`() {
        val plus1 = Cross(3,2,2)
        val plus2 = Cross(3,2,4)

        val overlaps = plus1.overlaps(plus2)

        Assertions.assertThat(overlaps).isTrue()
    }


}