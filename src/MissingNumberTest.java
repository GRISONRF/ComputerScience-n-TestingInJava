package src;
import static org.junit.Assert.*;
import org.junit.Test;

public class MissingNumberTest {

    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone =  { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private MissingNumber mn = new MissingNumber();


    @Test
    public void testMissingNumber_MissingMax(){
        assertEquals(10, mn.missingNumberSet(missingMax, 10));
        assertEquals(10, mn.missingNumbersOne(missingMax, 10));
        assertEquals(10, mn.missingNumberSort(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing(){
        assertEquals(0, mn.missingNumberSort(missingNone, 10));
        assertEquals(0, mn.missingNumbersOne(missingNone, 10));
        assertEquals(0, mn.missingNumberSet(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven(){
        assertEquals(7, mn.missingNumberSort(missingSeven, 10));
        assertEquals(7, mn.missingNumberSet(missingSeven, 10));
        assertEquals(7, mn.missingNumbersOne(missingSeven, 10));


    }

}
