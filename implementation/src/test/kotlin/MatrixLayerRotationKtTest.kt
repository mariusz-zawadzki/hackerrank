import org.assertj.core.api.Assertions
import org.junit.Test

class MatrixLayerRotationKtTest {

    @Test
    fun `should rotate 2 left`() {
        val rotateLeft = listOf<Int>(1, 2, 3, 4, 5).rotateLeft(2)

        Assertions.assertThat(rotateLeft).isEqualTo(listOf(3, 4, 5, 1, 2))
    }

    @Test
    fun `should rotate 13 left`() {
        val rotateLeft = listOf<Int>(1, 2, 3, 4, 5).rotateLeft(13)

        Assertions.assertThat(rotateLeft).isEqualTo(listOf(4, 5, 1, 2, 3))
    }


    @Test
    fun `should rotate matrix according to example 01`() {
        val matrix = Matrix(listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12),
                listOf(13, 14, 15, 16)

        ))

        val rotateMatrix = matrix.rotateMatrix(2)

        Assertions.assertThat(rotateMatrix).isEqualTo(
                Matrix(listOf(
                        listOf(3, 4, 8, 12),
                        listOf(2, 11, 10, 16),
                        listOf(1, 7, 6, 15),
                        listOf(5, 9, 13, 14)
                ))
        )
    }

    @Test
    fun `should rotate matrix according to example 02`() {
        val matrix = Matrix(listOf(
                listOf(1, 2, 3, 4),
                listOf(7, 8, 9, 10),
                listOf(13, 14, 15, 16),
                listOf(19, 20, 21, 22),
                listOf(25, 26, 27, 28)

        ))

        val rotateMatrix = matrix.rotateMatrix(7)

        Assertions.assertThat(rotateMatrix).isEqualTo(
                Matrix(listOf(
                        listOf(28, 27, 26, 25),
                        listOf(22, 9, 15, 19),
                        listOf(16, 8, 21, 13),
                        listOf(10, 14, 20, 7),
                        listOf(4, 3, 2, 1)
                ))
        )
    }

    @Test
    fun `should rotate matrix according to example 03`() {
        val matrix = Matrix(listOf(
                listOf(1, 1),
                listOf(1, 1)

        ))

        val rotateMatrix = matrix.rotateMatrix(3)

        Assertions.assertThat(rotateMatrix).isEqualTo(
                Matrix(listOf(
                        listOf(1, 1),
                        listOf(1, 1)
                ))
        )
    }

    @Test
    fun `should properly unwrap and wrap a matrix`() {
        val original = Matrix(listOf(
                listOf(1, 2, 3, 4, 5),
                listOf(6, 7, 8, 9, 10)
        ))
        val subMatrix = original.unwrap()


        Assertions.assertThat(subMatrix.first.wrapWith(subMatrix.second, original.rows)).isEqualTo(
                original
        )
    }

    @Test
    fun `should properly unwrap and wrap a matrix with two columns`() {
        val original = Matrix(listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6),
                listOf(7, 8)
        ))
        val subMatrix = original.unwrap()


        Assertions.assertThat(subMatrix.first.wrapWith(subMatrix.second, original.rows)).isEqualTo(
                original
        )
    }
}