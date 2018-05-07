import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class ProgrammersDayKtTest{
    @Test
    fun `should properly find for julian`() {
        val programmersDayDate = getProgrammersDayDate(1800)

        Assertions.assertThat(programmersDayDate).isEqualTo("12.09.1800")
    }

    @Test
    fun `should properly find for transition year 1918`() {
        val programmersDayDate = getProgrammersDayDate(1918)

        Assertions.assertThat(programmersDayDate).isEqualTo("26.09.1918")
    }

    @Test
    fun `should properly find for year 2016`() {
        val programmersDayDate = getProgrammersDayDate(2016)

        Assertions.assertThat(programmersDayDate).isEqualTo("12.09.2016")
    }

    @Test
    fun `should properly find for year 2017`() {
        val programmersDayDate = getProgrammersDayDate(2017)

        Assertions.assertThat(programmersDayDate).isEqualTo("13.09.2017")
    }
}