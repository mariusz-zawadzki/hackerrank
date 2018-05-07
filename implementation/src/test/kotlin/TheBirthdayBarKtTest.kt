import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class TheBirthdayBarKtTest{

    @Test
    fun `should return 0 if not enough bars`() {

        val segmentCount = getSegmentCount(listOf(), 1, 1)

        Assertions.assertThat(segmentCount).isEqualTo(0)
    }

    @Test
    fun `should return correct number for sample`() {
        val segmentCount = getSegmentCount(listOf(1, 2, 1, 3, 2), 3, 2)

        Assertions.assertThat(segmentCount).isEqualTo(2)
    }

    @Test
    fun `should return correct number for sample 1`() {
        val segmentCount = getSegmentCount(listOf(1,1,1,1,1,1), 3, 2)

        Assertions.assertThat(segmentCount).isEqualTo(0)
    }

    @Test
    fun `should return correct number for sample 2`() {
        val segmentCount = getSegmentCount(listOf(4), 4, 1)

        Assertions.assertThat(segmentCount).isEqualTo(1)
    }

    @Test
    fun `should return correct number for sample two`() {
        val segmentCount = getSegmentCount(listOf(1,1,1,1,1,1), 2, 2)

        Assertions.assertThat(segmentCount).isEqualTo(5)
    }
}