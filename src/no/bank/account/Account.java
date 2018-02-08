package no.bank.account;

import no.bank.account.exception.InvalidAccountNumberException;
import no.bank.account.exception.InvalidModuloCheckDigitException;
import no.bank.account.exception.MissingAccountNumberException;
import no.bank.account.util.Modulo11Utility;

import java.util.Scanner;

import static no.bank.account.util.Constants.*;

/**
 * Account facilitates a wrapper of an account number provides some basic functions to validates and check using Modulo 11
 */
public class Account {

    private final String accountNumber;

    /**
     * Account constructor provides initialization with account number and validated nullity and regex pattern
     * @param account
     */
    public Account(String account) {

        if (account == null || account.length() == 0 ) {
            throw new MissingAccountNumberException();
        }

        account = account.trim();

        if(!account.matches(VALID_ACCOUNT_NUMBER_REGEX)){
            throw new InvalidAccountNumberException(String.format("Invalid account number format, must be %s digits and contains dot(.) after 3rd and 6th character", VALID_ACCOUNT_NUMBER_LENGTH));
        }

        // setting account number without dot(.) and space if any
        this.accountNumber = account.replace(".", "");
    }

    /**
     * @return account number omitting control digit
     */
    private String getAccountNumberWithoutControlDigit(){
        int controlDigitIndex = this.accountNumber.length() - 1;
        return this.accountNumber.substring(0, controlDigitIndex);
    }

    /**
     * @return Last digit of an account number
     */
    private String getProvidedControlDigit(){
        int controlDigitIndex = this.accountNumber.length() - 1;
        return this.accountNumber.substring(controlDigitIndex);
    }

    /**
     * @return Uses Modulo11Utility to evaluate the check digit and matches with the provided one
     *  may throw exception if evaluation resulted '-'
     *  @see  Modulo11Utility
     */
    public boolean isValidModulo(){
        String evaluatedControlDigit = Modulo11Utility.evaluateCheckDigit(this.getAccountNumberWithoutControlDigit());
        if(AMBIGUOUS_CHECK_DIGIT.equals(evaluatedControlDigit)) throw new InvalidModuloCheckDigitException(String.format("Modulo resultant is an invalid check digit %s", evaluatedControlDigit));
        return this.getProvidedControlDigit().equals(evaluatedControlDigit);
    }

    /**
     * @return account number omitting separators
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }
}
