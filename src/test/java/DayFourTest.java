import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayFourTest {

    private DayFour dayFour;

    @Before
    public void setup() {
        this.dayFour = new DayFour();
    }

    @Test
    public void givenInput_returnsNestedCountOf_two() {
        assertEquals(2, dayFour.partOne(input));
    }

    @Test
    public void givenInput_returnsOverlappingCountOf_four() {
        assertEquals(4, dayFour.partTwo(input));
    }

    private static final String input =     "2-4,6-8\n" +
                                            "2-3,4-5\n" +
                                            "5-7,7-9\n" +
                                            "2-8,3-7\n" +
                                            "6-6,4-6\n" +
                                            "2-6,4-8";
}