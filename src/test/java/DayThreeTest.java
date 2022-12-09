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
        assertEquals(157, dayThree.partOne());
    }

    @Test
    public void givenInput_returnsScoreOf_70() {
        assertEquals(70, dayThree.partTwo());
    }

    private static final String input = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                                        "PmmdzqPrVvPwwTWBwg\n" +
                                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                                        "ttgJtRGJQctTZtZT\n" +
                                        "CrZsJsPPZsGzwwsLwLmpwMDw";

}

