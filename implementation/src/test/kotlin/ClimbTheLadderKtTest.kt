import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class ClimbTheLadderKtTest {
    @Test
    fun `should satisfy example 0`() {

        val climbingLeaderboard = climbingLeaderboard(listOf(100, 100, 50, 40, 40, 20, 10), listOf(5, 25, 50, 120))

        Assertions.assertThat(climbingLeaderboard).containsExactly(6,4,2,1)
    }
}