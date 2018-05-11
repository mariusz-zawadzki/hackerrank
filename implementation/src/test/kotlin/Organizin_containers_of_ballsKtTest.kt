import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class Organizin_containers_of_ballsKtTest{

    @Test
    fun `should satisfy example 0`() {
        val organizingContainers = organizingContainers(arrayOf(
                arrayOf(1, 1),
                arrayOf(1, 1)
        ))

        Assertions.assertThat(organizingContainers).isEqualTo(possible)
    }

    @Test
    fun `should satisfy example 0_1`() {
        val organizingContainers = organizingContainers(arrayOf(
                arrayOf(0, 2),
                arrayOf(1, 1)
        ))

        Assertions.assertThat(organizingContainers).isEqualTo(impossible)
    }
}