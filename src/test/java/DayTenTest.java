import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayTenTest {

    private DayTen dayTen;

    @Before
    public void setup() {
        this.dayTen = new DayTen(input);
    }

    @Test
    public void givenInput_returns_13140() {
        assertEquals(13140, dayTen.partOne());
    }

    private static final String input = "addx 15\n" +
                                        "addx -11\n" +
                                        "addx 6\n" +
                                        "addx -3\n" +
                                        "addx 5\n" +
                                        "addx -1\n" +
                                        "addx -8\n" +
                                        "addx 13\n" +
                                        "addx 4\n" +
                                        "noop\n" +
                                        "addx -1\n" +
                                        "addx 5\n" +
                                        "addx -1\n" +
                                        "addx 5\n" +
                                        "addx -1\n" +
                                        "addx 5\n" +
                                        "addx -1\n" +
                                        "addx 5\n" +
                                        "addx -1\n" +
                                        "addx -35\n" +
                                        "addx 1\n" +
                                        "addx 24\n" +
                                        "addx -19\n" +
                                        "addx 1\n" +
                                        "addx 16\n" +
                                        "addx -11\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 21\n" +
                                        "addx -15\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx -3\n" +
                                        "addx 9\n" +
                                        "addx 1\n" +
                                        "addx -3\n" +
                                        "addx 8\n" +
                                        "addx 1\n" +
                                        "addx 5\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx -36\n" +
                                        "noop\n" +
                                        "addx 1\n" +
                                        "addx 7\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 2\n" +
                                        "addx 6\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 7\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "addx -13\n" +
                                        "addx 13\n" +
                                        "addx 7\n" +
                                        "noop\n" +
                                        "addx 1\n" +
                                        "addx -33\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 2\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 8\n" +
                                        "noop\n" +
                                        "addx -1\n" +
                                        "addx 2\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "addx 17\n" +
                                        "addx -9\n" +
                                        "addx 1\n" +
                                        "addx 1\n" +
                                        "addx -3\n" +
                                        "addx 11\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx -13\n" +
                                        "addx -19\n" +
                                        "addx 1\n" +
                                        "addx 3\n" +
                                        "addx 26\n" +
                                        "addx -30\n" +
                                        "addx 12\n" +
                                        "addx -1\n" +
                                        "addx 3\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx -9\n" +
                                        "addx 18\n" +
                                        "addx 1\n" +
                                        "addx 2\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 9\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx -1\n" +
                                        "addx 2\n" +
                                        "addx -37\n" +
                                        "addx 1\n" +
                                        "addx 3\n" +
                                        "noop\n" +
                                        "addx 15\n" +
                                        "addx -21\n" +
                                        "addx 22\n" +
                                        "addx -6\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "addx 2\n" +
                                        "addx 1\n" +
                                        "noop\n" +
                                        "addx -10\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "addx 20\n" +
                                        "addx 1\n" +
                                        "addx 2\n" +
                                        "addx 2\n" +
                                        "addx -6\n" +
                                        "addx -11\n" +
                                        "noop\n" +
                                        "noop\n" +
                                        "noop";

}