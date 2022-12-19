import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayTwelveTest {

    DayTwelve dayTwelve;
    @Before
    public void setup() {
        this.dayTwelve = new DayTwelve(input);
    }

    @Test
    public void givenInput_returns_31() {
        assertEquals(31, dayTwelve.partOne());
    }

    @Test
    public void givenInput_returns_29() {
        assertEquals(29, dayTwelve.partTwo());
    }

    private static final String input = "Sabqponm\n" +
                                        "abcryxxl\n" +
                                        "accszExk\n" +
                                        "acctuvwj\n" +
                                        "abdefghi";
}