import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class MigratoryBirdsKtTest{
    @Test
    fun `should return 0 for none`() {
        val migratoryBirds = migratoryBirds(listOf<Int>())

        Assertions.assertThat(migratoryBirds).isZero()
    }

    @Test
    fun `should return expected result for example 0`() {
        val migratoryBirds = migratoryBirds(listOf<Int>(1, 4, 4, 4, 5, 3))


        Assertions.assertThat(migratoryBirds).isEqualTo(4)
    }

    @Test
    fun `should return lower if more than one have same commonality`() {
        val migratoryBirds = migratoryBirds(listOf<Int>(1, 1, 4, 4))


        Assertions.assertThat(migratoryBirds).isEqualTo(1)
    }
}