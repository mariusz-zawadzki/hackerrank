import org.assertj.core.api.Assertions
import org.junit.Test

class MatrixTest {
    @Test
    fun `should create proper submatrix`() {
        val subMatrix = Matrix(listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12),
                listOf(13, 14, 15, 16)
        )).subMatrix()


        Assertions.assertThat(subMatrix).isEqualTo(
                Matrix(listOf(
                        listOf(6, 7),
                        listOf(10, 11)
                ))
        )
    }

    @Test
    fun `should properly unwrap and wrap a matrix`() {
        val original = Matrix(listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12),
                listOf(13, 14, 15, 16)
        ))
        val subMatrix = original.unwrap()


        Assertions.assertThat(subMatrix.first.wrapWith(subMatrix.second,original.rows)).isEqualTo(
                original
        )
    }

    @Test
    fun `should create empty submatrix`() {
        val subMatrix = Matrix(listOf(
                listOf(6, 7),
                listOf(10, 11)
        )).subMatrix()

        Assertions.assertThat(subMatrix).isEqualTo(
                Matrix(listOf())
        )
    }

    @Test
    fun `should create edge and empty submatrix`() {
        val subMatrix = Matrix(listOf(
                listOf(6, 7),
                listOf(10, 11)
        )).unwrap()

        Assertions.assertThat(subMatrix.first).isEqualTo(
                Matrix(listOf())
        )
        Assertions.assertThat(subMatrix.second).isEqualTo(
                listOf(6, 7, 11, 10)
        )
    }

    @Test
    fun `should create edge proper submatrix`() {
        val subMatrix = Matrix(listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12),
                listOf(13, 14, 15, 16)
        )).unwrap()

        Assertions.assertThat(subMatrix.first).isEqualTo(
                Matrix(listOf(
                        listOf(6, 7),
                        listOf(10, 11)
                ))
        )
        Assertions.assertThat(subMatrix.second).isEqualTo(
                listOf(
                        1, 2, 3, 4,
                        8,
                        12,
                        16, 15, 14, 13,
                        9,
                        5
                )
        )
    }


}