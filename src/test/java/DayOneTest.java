import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayOneTest {

    DayOne dayOne = new DayOne();

    @Test
    public void givenInput_returns_caloriesSumOf_24000() {
        assertEquals(24000, dayOne.partOne(input));
    }

    @Test
    public void givenInput_returns_topThreeSumOf_45000() {
        int sumOne = dayOne.partOne(input);
        assertEquals(24000, sumOne);
        int sumTwo = dayOne.partTwo();
        assertEquals(45000, sumTwo);
    }

    private static final String input = "1000\n" +
                                        "2000\n" +
                                        "3000\n" +
                                        "\n" +
                                        "4000\n" +
                                        "\n" +
                                        "5000\n" +
                                        "6000\n" +
                                        "\n" +
                                        "7000\n" +
                                        "8000\n" +
                                        "9000\n" +
                                        "\n" +
                                        "10000";
}