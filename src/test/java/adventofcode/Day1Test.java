package adventofcode;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day1Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {12, 2}, {14, 2}, {1969, 654}, {100756, 33583}
        });
    }

    private int input;
    private int expected;

    public Day1Test(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testIt() {
        // given
        BigDecimal mass = new BigDecimal(input);

        // when
        BigDecimal fuel = Day1.fuel(mass);

        // then
        assertThat(fuel, Is.is(new BigDecimal(expected)));

    }

}
