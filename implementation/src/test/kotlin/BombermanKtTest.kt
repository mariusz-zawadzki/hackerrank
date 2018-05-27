import org.assertj.core.api.Assertions
import org.junit.Test

import org.junit.Assert.*

class BombermanKtTest {

    @Test
    fun `should satisfy example 0`() {
        val input = """
            .......
            ...O...
            ....O..
            .......
            OO.....
            OO.....""".trimIndent().lines().toTypedArray()
        val n = 3
        val output = bomberMan(n, input)

        Assertions.assertThat(output).isEqualTo("""
            OOO.OOO
            OO...OO
            OOO...O
            ..OO.OO
            ...OOOO
            ...OOOO
            """.trimIndent().lines().toTypedArray())
    }

    @Test
    fun `should display some kind of patter`() {
        val input = """
            .......
            ...O...
            ....O..
            .......
            OO.....
            OO.....""".trimIndent().lines().toTypedArray()
        val n = 11
        val output = bomberMan(n, input)

        Assertions.assertThat(output).isEqualTo("""
            OOO.OOO
            OO...OO
            OOO...O
            ..OO.OO
            ...OOOO
            ...OOOO
            """.trimIndent().lines().toTypedArray())
    }

    @Test
    fun `should basic explanation`() {
        val input = """
            ...
            .O.
            ...""".trimIndent().lines().toTypedArray()
        val n = 3
        val output = bomberMan(n, input)

        Assertions.assertThat(output).isEqualTo("""
            O.O
            ...
            O.O""".trimIndent().lines().toTypedArray())
    }
}