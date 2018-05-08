import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void shouldReturnProperlyForExample0Query0() {
        String s = Solution.catAndMouse(1, 2, 3);

        Assertions.assertThat(s).isEqualTo(Solution.BCAT);
    }

    @Test
    public void shouldReturnProperlyForExample0Query1() {
        String s = Solution.catAndMouse(1, 3, 2);

        Assertions.assertThat(s).isEqualTo(Solution.MOUSE);
    }
}