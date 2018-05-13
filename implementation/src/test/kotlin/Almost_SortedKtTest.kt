import org.assertj.core.api.Assertions
import org.junit.Test

class Almost_SortedKtTest {
    @Test
    fun `should satisfy example 1`() {
        val almostSorted = almostSorted(listOf(4, 2))

        Assertions.assertThat(almostSorted).isEqualTo(
                """
                    yes
                    swap 1 2
                """.trimIndent()
        )
    }
    @Test
    fun `should satisfy example 2`() {
        val almostSorted = almostSorted(listOf(3, 1, 2))

        Assertions.assertThat(almostSorted).isEqualTo(
                """
                    no
                """.trimIndent()
        )
    }
    @Test
    fun `should satisfy example 2 with modification`() {
        val almostSorted = almostSorted(listOf(2, 1, 3))

        Assertions.assertThat(almostSorted).isEqualTo(
                """
                    yes
                    swap 1 2
                """.trimIndent()
        )
    }

    @Test
    fun `should satisfy example 3`() {
        val almostSorted = almostSorted(listOf(1,5,4,3,2,6))

        Assertions.assertThat(almostSorted).isEqualTo(
                """
                    yes
                    reverse 2 5
                """.trimIndent()
        )
    }

    @Test
    fun `should satisfy test case #1`() {
        val input = "4104 8529 49984 54956 63034 82534 84473 86411 92941 95929 108831 894947 125082 137123 137276 142534 149840 154703 174744 180537 207563 221088 223069 231982 249517 252211 255192 260283 261543 262406 270616 274600 274709 283838 289532 295589 310856 314991 322201 339198 343271 383392 385869 389367 403468 441925 444543 454300 455366 469896 478627 479055 484516 499114 512738 543943 552836 560153 578730 579688 591631 594436 606033 613146 621500 627475 631582 643754 658309 666435 667186 671190 674741 685292 702340 705383 722375 722776 726812 748441 790023 795574 797416 813164 813248 827778 839998 843708 851728 857147 860454 861956 864994 868755 116375 911042 912634 914500 920825 979477".split(" ").map { it.trim().toInt() }
        val expectedOutput = """
            yes
            swap 12 95
            """.trimIndent()

        val almostSorted = almostSorted(input)

        Assertions.assertThat(almostSorted).isEqualTo(
                expectedOutput)
    }

    @Test
    fun `should satisfy test case #24`() {
        val input = "43 65 1 98 99 101".split(" ").map { it.trim().toInt() }
        val expectedOutput = """
            no
            """.trimIndent()

        val almostSorted = almostSorted(input)

        Assertions.assertThat(almostSorted).isEqualTo(
                expectedOutput)
    }
}