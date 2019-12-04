package adventofcode;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class Day1Test {

    @RunWith(Parameterized.class)
    public static class Part1 {

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {12, 2}, {14, 2}, {1969, 654}, {100756, 33583}
            });
        }

        private int input;
        private int expected;

        public Part1(int input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        @Test
        public void testIt() {
            // when
            int fuel = Day1.fuel(input);

            // then
            assertThat(fuel, is(expected));

        }
    }

    @RunWith(Parameterized.class)
    public static class Part2 {

        @Parameterized.Parameters(name = "mass={0}, fuel={1}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {14, 2},
                    {1969, 966},
                    {100756, 50346},
            });
        }

        private int input;
        private int expected;

        public Part2(int input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        @Test
        public void testIt() {
            // when
            int fuel = Day1.total(input);

            // then
            assertThat(fuel, is(expected));

        }
    }


}
