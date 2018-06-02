import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test
import java.io.StringReader
import java.util.*

class BigSortingKtTest{
    @Test
    fun `satisfiec test case 3`() {
        "/big-sorting_output03.txt".asResource {output->
            "/big-sorting_input03.txt".asResource {
                val builder = StringBuilder()
                val n = it.lines()
                getLinesForBigSort(n.size, Scanner(StringReader(it)), { builder.append(it)})
                Assertions.assertThat(builder.toString()).isEqualTo(output)
            }
        }
    }

    @Test
    fun `satisfiec test case 6`() {
        "/big-sorting_output06.txt".asResource {output->
            "/big-sorting_input06.txt".asResource {
                val builder = StringBuilder()
                val n = it.lines()
                getLinesForBigSort(n.size, Scanner(StringReader(it)), { builder.append(it)})
                Assertions.assertThat(builder.toString()).isEqualTo(output)
            }
        }
    }
}



fun String.asResource(work: (String) -> Unit) {
    val content = this.javaClass::class.java.getResource(this).readText()
    work(content)
}