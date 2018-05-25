import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.Test

class Absolute_PermutationsKtTest {

    @Test
    fun `should satisfy example from description`() {
        val absolutePermutation = absolutePermutation(4, 2)

        Assertions.assertThat(absolutePermutation).isEqualTo(listOf(3, 4, 1, 2))
    }
    @Test
    fun `should properly permutate by one`() {
        val absolutePermutation = absolutePermutation(10, 1)

        Assertions.assertThat(absolutePermutation).isEqualTo(listOf(2, 1, 4, 3,6,5,8,7,10,9))
    }

    @Test
    fun `should properly permutate by two`() {
        val absolutePermutation = absolutePermutation(8, 2)

        Assertions.assertThat(absolutePermutation).isEqualTo(listOf(3,4,1,2,7,8,5,6))
    }

    @Test
    fun `should satisfy example from sample 0`() {
        val absolutePermutation = absolutePermutation(2, 1)

        Assertions.assertThat(absolutePermutation).containsExactly(2, 1)
    }

    @Test
    fun `should satisfy example from sample 0 1`() {
        val absolutePermutation = absolutePermutation(3, 0)

        Assertions.assertThat(absolutePermutation).containsExactly(1, 2, 3)
    }

    @Test
    fun `should satisfy example from sample 0 2`() {
        val absolutePermutation = absolutePermutation(3, 2)

        Assertions.assertThat(absolutePermutation).containsExactly(-1)
    }


    @Test
    fun `should satisfy test 9`() {

        val inputFile = "/Absolute_Permutation_input9.txt"
        val outputFile = "/Absolute_Permutation_output9.txt"
        test(inputFile, outputFile)
    }
    @Test
    fun `should satisfy test 2`() {

        val inputFile = "/Absolute_Permutation_input2.txt"
        val outputFile = "/Absolute_Permutation_output2.txt"
        test(inputFile, outputFile)
    }
    @Test
    fun `should satisfy test 10`() {

        val inputFile = "/Absolute_Permutation_input10.txt"
        val outputFile = "/Absolute_Permutation_output10.txt"
        test(inputFile, outputFile)
    }

    private fun test(inputFile: String, outputFile: String) {
        inputFile.asResource { input ->
            outputFile.asResource { output ->
                input.lineSequence().zip(
                        output.lineSequence()
                )
                        .forEach { ita ->
                            val (n, k) = ita.first.split(" ").map { it.trim().toInt() }
                            val absolutePermutation = absolutePermutation(n, k).joinToString(separator = " ")
                            val map = ita.second

                            Assertions.assertThat(absolutePermutation)
                                    .describedAs("Should properly find permutation of $n and $k")
                                    .isEqualTo(map)
                        }

            }
        }
    }

    fun String.asResource(work: (String) -> Unit) {
        val content = this.javaClass::class.java.getResource(this).readText()
        work(content)
    }
}