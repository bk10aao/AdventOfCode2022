import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class DaySixTest {



    @Test
    public void givenInput_mjqjpqmgbljsphdztnvjfqwrcgsmlb_withPacketLengthOf_4_returnsMarkerOf_7() {
        DaySix daySix = new DaySix();
        assertEquals(7, daySix.partOne("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4));
    }

    @Test
    public void givenInput_bvwbjplbgvbhsrlpgdmjqwftvncz_withPacketLengthOf_4_returnsMarkerOf_5() {
        DaySix daySix = new DaySix();
        assertEquals(5, daySix.partOne("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
    }

    @Test
    public void givenInput_nppdvjthqldpwncqszvftbrmjlhg_withPacketLengthOf_4_returnsMarkerOf_6() {
        DaySix daySix = new DaySix();
        assertEquals(6, daySix.partOne("nppdvjthqldpwncqszvftbrmjlhg", 4));
    }

    @Test
    public void givenInput_nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg_withPacketLengthOf_4_returnsMarkerOf_10() {
        DaySix daySix = new DaySix();
        assertEquals(10, daySix.partOne("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
    }

    @Test
    public void givenInput_zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw_withPacketLengthOf_4_returnsMarkerOf_11() {
        DaySix daySix = new DaySix();
        assertEquals(11, daySix.partOne("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));
    }

    @Test
    public void givenInput_mjqjpqmgbljsphdztnvjfqwrcgsmlb_withPacketLengthOf_14_returnsMarkerOf_19() {
        DaySix daySix = new DaySix();
        assertEquals(19, daySix.partOne("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14));
    }

    @Test
    public void givenInput_bvwbjplbgvbhsrlpgdmjqwftvncz_withPacketLengthOf_14_returnsMarkerOf_23() {
        DaySix daySix = new DaySix();
        assertEquals(23, daySix.partOne("bvwbjplbgvbhsrlpgdmjqwftvncz", 14));
    }

    @Test
    public void givenInput_nppdvjthqldpwncqszvftbrmjlhg_withPacketLengthOf_14_returnsMarkerOf_23() {
        DaySix daySix = new DaySix();
        assertEquals(23, daySix.partOne("nppdvjthqldpwncqszvftbrmjlhg", 14));
    }

    @Test
    public void givenInput_nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg_withPacketLengthOf_14_returnsMarkerOf_29() {
        DaySix daySix = new DaySix();
        assertEquals(29, daySix.partOne("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14));
    }

    @Test
    public void givenInput_zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw_withPacketLengthOf_14_returnsMarkerOf_26() {
        DaySix daySix = new DaySix();
        assertEquals(26, daySix.partOne("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14));
    }
}