package no.bank.account.exception;

public class InvalidModuloCheckDigitException extends RuntimeException {

    private static final String defaultMessage = "Modulo resultant an invalid check digit";

    public InvalidModuloCheckDigitException(){
        super(defaultMessage);
    }

    public InvalidModuloCheckDigitException(String message){
        super(message);
    }
}
