package no.bank.account.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests Modulo11Utility
 */
public class Modulo11UtilityTest {

    @Test
    public void testExpectedWeightNumber(){
        int[] expected = new int[]{2,3,4,5,6,7,2,3,4,5,6,7,2,3,4,5,6,7,2,3,4,5,6,7,2,3,4,5,6,7};
        int[] actual = new int[expected.length];
        for(int i = 0; i<expected.length; i++ ){
            actual[i] = ((i % 6) + 2);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void evaluate() {
        Assert.assertEquals("3", Modulo11Utility.evaluateCheckDigit("1234567890"));
    }

    @Test
    public void evaluateWithNull() {
        Assert.assertNull(Modulo11Utility.evaluateCheckDigit(null));
    }

    @Test
    public void evaluateWithEmpty() {
        Assert.assertNull(Modulo11Utility.evaluateCheckDigit(""));
    }

    @Test
    public void testAmbiguousCheckDigit(){
        Assert.assertEquals(Constants.AMBIGUOUS_CHECK_DIGIT, Modulo11Utility.evaluateCheckDigit("1110000000"));
    }

    @Test
    public void testValidateCheckDigit(){
        Assert.assertTrue(Modulo11Utility.validateCheckDigit("2412167822", "1"));
    }
}