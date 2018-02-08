package no.bank.account;

import no.bank.account.exception.InvalidAccountNumberException;
import no.bank.account.exception.InvalidModuloCheckDigitException;
import no.bank.account.exception.MissingAccountNumberException;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void validAccountNumberValidation() {
        Assert.assertEquals("12345678903",new Account("1234.56.78903").getAccountNumber());
    }

    @Test(expected = MissingAccountNumberException.class)
    public void nullAccountNumberValidation() {
        new Account(null);
    }

    @Test(expected = MissingAccountNumberException.class)
    public void emptyAccountNumberValidation() {
        new Account("");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void invalidLengthAccountNumberValidation() {
        new Account("1234.56.7890");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void missingDotsAccountNumberValidation() {
        new Account("12345678903");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void alphaNumericAccountNumberValidation() {
        new Account("acdefgh123");
    }

    @Test
    public void containingPreAndPostSpaceAccountNumberValidation() {
        Assert.assertEquals("12345678903", new Account(" 1234.56.78903 ").getAccountNumber()   );
    }

    @Test
    public void validAccountNumberModuloValidation() {
        Assert.assertTrue(new Account("1234.56.78903").isValidModulo());
    }

    @Test
    public void invalidAccountNumberModuloValidation() {
        Assert.assertFalse(new Account("1234.56.78900").isValidModulo());
    }

    @Test(expected = InvalidModuloCheckDigitException.class)
    public void ambiguousControlDigitAccountNumberModuloValidation(){
        Assert.assertTrue(new Account("1110.00.00000").isValidModulo());
    }
}
