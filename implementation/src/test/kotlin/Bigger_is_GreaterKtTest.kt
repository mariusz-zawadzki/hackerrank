import org.assertj.core.api.Assertions
import org.junit.Test

class Bigger_is_GreaterKtTest{

    @Test
    fun `should match inputs of example 0`() {

        listOf<String>(
                "ab", "bb", "hefg", "dhck",
                "dkhc")
                .zip(
        listOf<String>(
                "ba", "no answer", "hegf","dhkc",
                "hcdk"))
                .forEach {
                    val biggerIsGreater = biggerIsGreater(it.first)

                    Assertions.assertThat(biggerIsGreater).isEqualTo(it.second)
                }
    }

    @Test
    fun `should satisfy testcase #2`() {
        "/Bigger_is_Greater_input2.txt".asResource { input ->
            "/Bigger_is_Greater_output2.txt".asResource { output ->
                input.lineSequence().zip(
                        output.lineSequence()
                )
                        .forEach { ita ->
                            val biggerIsGreater = biggerIsGreater(ita.first)
                            Assertions.assertThat(biggerIsGreater).isEqualTo(ita.second)
                        }

            }
        }
    }
    fun String.asResource(work: (String) -> Unit) {
        val content = this.javaClass::class.java.getResource(this).readText()
        work(content)
    }
}