import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class Encryption_ProblemKtTest{


    @Test
    fun `should satisfy example from description`() {
        val input = "if man was meant to stay on the ground god would have given us roots";

        val encrypted = encryption(input)

        Assertions.assertThat(encrypted).isEqualTo("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau")
    }

    @Test
    fun `should satisfy example 0`() {
        val input = "haveaniceday";

        val encrypted = encryption(input)

        Assertions.assertThat(encrypted).isEqualTo("hae and via ecy")
    }

    @Test
    fun `should satisfy example 1`() {
        val input = "feedthedog ";

        val encrypted = encryption(input)

        Assertions.assertThat(encrypted).isEqualTo("fto ehg ee dd")
    }

    @Test
    fun `should satisfy example 2`() {
        val input = "chillout ";

        val encrypted = encryption(input)

        Assertions.assertThat(encrypted).isEqualTo("clu hlt io")
    }
}