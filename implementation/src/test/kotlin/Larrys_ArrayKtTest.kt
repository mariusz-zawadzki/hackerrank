import org.assertj.core.api.Assertions
import org.junit.Test

class Larrys_ArrayKtTest {
    @Test
    fun `should satisfy example 0 0`() {
        val larrysArray = larrysArray(listOf(3, 1, 2))

        Assertions.assertThat(larrysArray).isEqualTo(YES)
    }

    @Test
    fun `should satisfy example 0 1`() {
        val larrysArray = larrysArray(listOf(1, 3, 4, 2))

        Assertions.assertThat(larrysArray).isEqualTo(YES)
    }

    @Test
    fun `should satisfy example 0 2`() {
        val larrysArray = larrysArray(listOf(1, 2, 3, 5, 4))

        Assertions.assertThat(larrysArray).isEqualTo(NO)
    }


    @Test
    fun `should satisfy something else`() {
        val larrysArray = larrysArray(listOf(1, 2, 6, 5, 4, 3))

        Assertions.assertThat(larrysArray).isEqualTo(YES)
    }
    @Test
    fun `should satisfy something else that is ok`() {
        val larrysArray = larrysArray(listOf(1, 6, 4, 3, 5, 2))

        Assertions.assertThat(larrysArray).isEqualTo(YES)
    }

    @Test
    fun `should satisfy something else that is not ok`() {
        val larrysArray = larrysArray(listOf(1, 6, 4, 3, 2, 5))

        Assertions.assertThat(larrysArray).isEqualTo(NO)
    }
}
