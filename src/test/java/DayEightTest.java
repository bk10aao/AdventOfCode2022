import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class DayEightTest {

    private DayEight dayEight;

    @Before
    public void setup() {
        this.dayEight = new DayEight();
    }

    @Test
    public void givenInput_returns_21() {
        assertEquals(21, dayEight.partOne(input));
    }

    private String input =  "30373\n" +
                            "25512\n" +
                            "65332\n" +
                            "33549\n" +
                            "35390";

}