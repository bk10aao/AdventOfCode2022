import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class DaySixTest {

    @Test
    public void givenInput_mjqjpqmgbljsphdztnvjfqwrcgsmlb_withPacketLengthOf_4_returnsMarkerOf_7() {
        assertEquals(7, DaySix.solve("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4));
    }

    @Test
    public void givenInput_bvwbjplbgvbhsrlpgdmjqwftvncz_withPacketLengthOf_4_returnsMarkerOf_5() {
        assertEquals(5, DaySix.solve("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
    }

    @Test
    public void givenInput_nppdvjthqldpwncqszvftbrmjlhg_withPacketLengthOf_4_returnsMarkerOf_6() {
        assertEquals(6, DaySix.solve("nppdvjthqldpwncqszvftbrmjlhg", 4));
    }

    @Test
    public void givenInput_nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg_withPacketLengthOf_4_returnsMarkerOf_10() {
        assertEquals(10, DaySix.solve("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
    }

    @Test
    public void givenInput_zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw_withPacketLengthOf_4_returnsMarkerOf_11() {
        assertEquals(11, DaySix.solve("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));
    }

    @Test
    public void givenInput_mjqjpqmgbljsphdztnvjfqwrcgsmlb_withPacketLengthOf_14_returnsMarkerOf_19() {
        assertEquals(19, DaySix.solve("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14));
    }

    @Test
    public void givenInput_bvwbjplbgvbhsrlpgdmjqwftvncz_withPacketLengthOf_14_returnsMarkerOf_23() {
        assertEquals(23, DaySix.solve("bvwbjplbgvbhsrlpgdmjqwftvncz", 14));
    }

    @Test
    public void givenInput_nppdvjthqldpwncqszvftbrmjlhg_withPacketLengthOf_14_returnsMarkerOf_23() {
        assertEquals(23, DaySix.solve("nppdvjthqldpwncqszvftbrmjlhg", 14));
    }

    @Test
    public void givenInput_nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg_withPacketLengthOf_14_returnsMarkerOf_29() {
        assertEquals(29, DaySix.solve("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14));
    }

    @Test
    public void givenInput_zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw_withPacketLengthOf_14_returnsMarkerOf_26() {
        assertEquals(26, DaySix.solve("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14));
    }
}