import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class Queen_s_AttackKtTest{

    @Test
    fun `should satisfy example 0`() {

        val queensAttack = queensAttack(4,  4, 4,
                arrayOf(

                ))

        Assertions.assertThat(queensAttack).isEqualTo(9)
    }

    @Test
    fun `should satisfy example 1`() {

        val queensAttack = queensAttack(5,  4, 3,
                arrayOf(
                        arrayOf(5,5),
                        arrayOf(4,2),
                        arrayOf(2,3)
                ))

        Assertions.assertThat(queensAttack).isEqualTo(10)
    }
    @Test
    fun `should calculate correct for queen on the edge`() {

        val queensAttack = queensAttack(2,  2, 2,
                arrayOf(
                ))

        Assertions.assertThat(queensAttack).isEqualTo(3)
    }
    @Test
    fun `should calculate correct for queen on the starting position`() {

        val queensAttack = queensAttack(3,  1, 1,
                arrayOf())

        Assertions.assertThat(queensAttack).isEqualTo(6)
    }
    @Test
    fun `should calculate correct for queen on the starting position with obstacles`() {

        val queensAttack = queensAttack(3,  1, 1,
                arrayOf(
                        arrayOf(2,2),
                        arrayOf(2,2),
                        arrayOf(2,2)
                ))

        Assertions.assertThat(queensAttack).isEqualTo(4)
    }

    @Test
    fun `should satisfy example 2`() {

        val queensAttack = queensAttack(1,  1, 1,
                arrayOf(
                ))

        Assertions.assertThat(queensAttack).isEqualTo(0)
    }
}