import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTwoTest {

    DayTwo dayTwo;

    @Before
    public void setup() {
        dayTwo = new DayTwo(input);
    }

    @Test
    public void givenInput_returnsTotalScoreOf_15() {
        assertEquals(15, dayTwo.partOne());
    }

    @Test
    public void givenInput_returnsScoreOf_12() {
        assertEquals(12, dayTwo.partTwo());
    }

    private static final String input = "A Y\n" +
                                        "B X\n" +
                                        "C Z";
}