package adventofcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class Day3Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"R8,U5,L5,D3", "U7,R6,D4,L4", 6},
                {"R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", 159},
                {"R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", 135},
        });
    }

    private final String wire1;
    private final String wire2;
    private final int distance;

    public Day3Test(String wire1, String wire2, int distance) {
        this.wire1 = wire1;
        this.wire2 = wire2;
        this.distance = distance;
    }

    @Test
    public void testIt() {
        // given

        // when
        int result = new Day3(wire1, wire2).distance();

        // then
        Assert.assertThat(result, is(distance));

    }
}
