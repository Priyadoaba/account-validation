package no.bank.account.util;

import static no.bank.account.util.Constants.AMBIGUOUS_CHECK_DIGIT;

/**
 * A Modulo 11 utility which generates and validates check digit
 */
public class Modulo11Utility {

    /**
     * @param input a string presentation of a numeric value
     * @return String check digit as it may contain dash
     */
    public static String evaluateCheckDigit(String input){
        if(input == null || input.isEmpty()){
            return null;
        }
        String checkDigit;
        int sum = 0;
        //System.out.println("number to evaluate modulo 11: "+ input);
        for(int indexFromRight = input.length()-1; indexFromRight >= 0 ; indexFromRight--){
            int indexFromLeft = (input.length()-1) - indexFromRight ;
            sum += Character.getNumericValue(input.charAt(indexFromRight)) * (indexFromLeft % 6 + 2);
        }
        //System.out.println("sum for control digit evaluation: "+ sum);
        int rest = sum % 11;
        if (rest == 0) {
            checkDigit = "0";
        } else if (rest == 1) {
            checkDigit = AMBIGUOUS_CHECK_DIGIT;
        } else {
            checkDigit = String.valueOf(11 - rest);
        }
        //System.out.println("evaluated control digit: "+ checkDigit);
        return checkDigit;
    }

    /**
     * @param input
     * @param expectedCheckDigit
     * @return true if matches
     */
    public static boolean validateCheckDigit(String input, String expectedCheckDigit){
        return expectedCheckDigit.equals(evaluateCheckDigit(input));
    }
}
