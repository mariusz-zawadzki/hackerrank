import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test
import java.math.BigInteger

class ExtraLongFactorialKtTest{
    @Test
    fun `should calculate big factorial`() {
        val bigFactorial = bigFactorial(25)

        Assertions.assertThat(bigFactorial).isEqualTo(BigInteger("15511210043330985984000000"))
    }
}