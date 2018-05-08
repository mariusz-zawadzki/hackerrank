import org.assertj.core.api.Assertions
import org.junit.Test

class SocksMatcherKtTest {
    @Test
    fun `should match 0 for no socks`() {
        val socksMatches = socksMatches(listOf())

        Assertions.assertThat(socksMatches).isEqualTo(0)
    }

    @Test
    fun `should match 1 for only one pair socks`() {
        val socksMatches = socksMatches(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 1))

        Assertions.assertThat(socksMatches).isEqualTo(1)
    }

    @Test
    fun `should match 3 for example `() {
        val socksMatches = socksMatches(listOf(10, 20, 20, 10, 10, 30, 50, 10, 20))

        Assertions.assertThat(socksMatches).isEqualTo(3)
    }
}