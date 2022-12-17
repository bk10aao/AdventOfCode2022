import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayFiveTest {

    DayFive dayFive;

    @Before
    public void setup() {
        this.dayFive = new DayFive(input);
    }

    @Test
    public void givenInput_returns_CMZ() {
        String result = dayFive.partOne();
        assertEquals("CMZ", result);
    }

    @Test
    public void givenInput_returns_MCD() {
        String result = dayFive.partTwo();
        assertEquals("MCD", result);
    }

    private String input =  "    [D]    \n" +
                            "[N] [C]    \n" +
                            "[Z] [M] [P]\n" +
                            " 1   2   3 \n" +
                            "\n" +
                            "move 1 from 2 to 1\n" +
                            "move 3 from 1 to 3\n" +
                            "move 2 from 2 to 1\n" +
                            "move 1 from 1 to 2";
}