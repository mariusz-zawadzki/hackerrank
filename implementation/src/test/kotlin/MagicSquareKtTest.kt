import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class MagicSquareKtTest
{
    @Test
    fun `print magic squares`() {

        print("listOf(")
        magicSquares().forEach {
            println("Triple(")
            println("Triple${it.first},")
            println("Triple${it.second},")
            println("Triple${it.third})")
            println(",")
        }
        print(")")
    }


    @Test
    fun `should properly find min difference for magic square`() {
        val minDifference = getMinDifference(Triple(
                Triple(2, 7, 6),
                Triple(9, 5, 1),
                Triple(4, 3, 8)).toList().flatMap { it.toList() })

        Assertions.assertThat(minDifference).isEqualTo(0)
    }

    @Test
    fun `should properly find min difference for some sqiare`() {
        val minDifference = getMinDifference(Triple(
                Triple(2, 7, 7),
                Triple(9, 5, 1),
                Triple(4, 4, 8)).toList().flatMap { it.toList() })

        Assertions.assertThat(minDifference).isEqualTo(2)
    }
}