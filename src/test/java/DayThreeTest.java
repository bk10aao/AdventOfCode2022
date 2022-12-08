import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;import junit.framework.TestCase;

public class DayThreeTest  {

    private DayThree dayThree;

    @Before
    public void setup() {
        this.dayThree = new DayThree(input);
    }
    @Test
    public void givenInput_returnsScoreOf_157() {
        int result = dayThree.partOne();
        assertEquals(157, result );
    }

    @Test
    public void givenInput_returnsScoreOf_70() {
        int result = dayThree.partTwo();
        assertEquals(70, result);
    }

    private static final String input = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                                        "PmmdzqPrVvPwwTWBwg\n" +
                                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                                        "ttgJtRGJQctTZtZT\n" +
                                        "CrZsJsPPZsGzwwsLwLmpwMDw";
}

