import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClockDegreeCalcTest {
    private ClockDegreeCalc clockDegreeCalc;
    @Before
    public void setUp() throws Exception {
        clockDegreeCalc = new ClockDegreeCalc();
    }

    @After
    public void tearDown() throws Exception {
        clockDegreeCalc = null;
    }

    @Test
    public void testHour_1_Minute_0() {
        assertEquals(30, clockDegreeCalc.getAngle(1,0), 0);
    }

    @Test
    public void testHour_6_Minute_0() {
        assertEquals(180, clockDegreeCalc.getAngle(6,0), 0);
    }

    @Test
    public void testHour_15_Minute_30() {
        assertEquals(75, clockDegreeCalc.getAngle(15,30), 0);
    }

    @Test
    public void testZeroHourMinute() {
        assertEquals(0, clockDegreeCalc.getAngle(0,0), 0);
    }

    @Test
    public void testCalculateMinuteAngle() {
        assertEquals(30, clockDegreeCalc.calculateMinuteAngle(5));
    }

    @Test
    public void testCalculateMinuteAngle_Minute_60() {
        assertEquals(0, clockDegreeCalc.calculateMinuteAngle(0));
    }

    @Test
    public void testCalculateMinuteAngle_Negative_60() {
        assertEquals(360, clockDegreeCalc.calculateMinuteAngle(-60));
    }

    @Test
    public void testCalculateHourAngle_00_01() {
        assertEquals(0.5, clockDegreeCalc.calculateHourAngle(0, 1), 0);
    }

    @Test
    public void testCalculateHourAngle_02_05() {
        assertEquals(62.5, clockDegreeCalc.calculateHourAngle(2, 5), 0);
    }

    @Test
    public void testCalculateHourAngleNegative_02_05() {
        assertEquals(62.5, clockDegreeCalc.calculateHourAngle(-2, -5), 0);
    }

    @Test
    public void calculateClockAngleBigHour() {
        assertEquals(120, clockDegreeCalc.getAngle(1000, 0), 0);
    }

    @Test
    public void calculateClockAngleBigMinute() {
        assertEquals(0, clockDegreeCalc.getAngle(0, 3600), 0);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void tryNoArguments() throws ArrayIndexOutOfBoundsException {
        clockDegreeCalc.checkForArguments(new String[0]);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void tryOneArgument() throws ArrayIndexOutOfBoundsException {
        clockDegreeCalc.checkForArguments(new String[]{"1"});
    }

    @Test
    public void tryValidArguments() throws ArrayIndexOutOfBoundsException {
        assertTrue(clockDegreeCalc.checkForArguments(new String[]{"1", "2"}));
    }

    @Test
    public void tryMoreThanTwoArguments() throws ArrayIndexOutOfBoundsException {
        assertTrue(clockDegreeCalc.checkForArguments(new String[]{"1", "2", "3"}));
    }

    @Test (expected = NumberFormatException.class)
    public void tryNonIntegerStringsAsArguments() throws NumberFormatException {
        clockDegreeCalc.checkForArguments(new String[]{"abc", "cde"});
    }

    @Test (expected = NumberFormatException.class)
    public void tryOneNonIntegerStringsAsArgument() throws NumberFormatException {
        clockDegreeCalc.checkForArguments(new String[]{"abc"});
    }

    @Test
    public void testReduceOverAngle() {
        assertEquals(1, clockDegreeCalc.reduceOverAngle(721), 0);
    }
}