import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class TheGridSearchKtTest{
    @Test
    fun `should match example 0`() {
        val input = """7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137"""

        val P = """9505
3845
3530"""

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }

    @Test
    fun `should match example 0 modified`() {
        val input = """
            7283455864
            6731158619
            8988242643
            3830589324
            2229505813
            2229505813
            5633845374
            6473530293
            7053106601
            0834282956
            4607924137""".trimIndent()

        val P = """
            9505
            3845
            3530""".trimIndent()

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }
    @Test
    fun `should match example 0 with later no match`() {
        val input = """
            7283455864
            6731158619
            8988242643
            3830589324
            2229505813
            5633845374
            6473530293
            7053106601
            0834282956
            2229505813
            4607924137""".trimIndent()

        val P = """
            9505
            3845
            3530""".trimIndent()

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }
    @Test
    fun `should match one line part`() {
        val input = """
            7283455864
            6731158619
            8988242643
            3830589324
            2229505813
            5633845374
            6473530293
            7053106601
            0834282956
            4607924137""".trimIndent()

        val P = """9505"""

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }

    @Test
    fun `should match lower corner`() {
        val input = """
            7283455864
            6731158619
            8988242643
            3830589324
            2229505813
            5633845374
            6473530293
            7053106601
            0834282956
            4607924137""".trimIndent()

        val P = """
            956
            137
        """.trimIndent()

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }
    @Test
    fun `should match one fullLine`() {
        val input = """
            7283455864
            6731158619
            8988242643
            3830589324
            2229505813
            5633845374
            6473530293
            7053106601
            0834282956
            4607924137""".trimIndent()

        val P = """2229505813"""

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }
    @Test
    fun `should match test case 8`() {
        val input = """
            999999
            121211""".trimIndent()

        val P = """
            99
            11
        """.trimIndent()

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }

    @Test
    fun `should match test case 9`() {
        val input = """
            111111111111111
            111111111111111
            111111011111111
            111111111111111
            111111111111111""".trimIndent()

        val P = """
            11111
            11111
            11110""".trimIndent()

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }

    @Test
    fun `should match same array`() {
        val input = """
            7283455864
            6731158619
            8988242643
            3830589324
            2229505813
            5633845374
            6473530293
            7053106601
            0834282956
            4607924137""".trimIndent()

        val P = input

        val result = gridSearch(input.lines().toTypedArray(), P.lines().toTypedArray())

        Assertions.assertThat(result).isEqualTo("YES")
    }
}