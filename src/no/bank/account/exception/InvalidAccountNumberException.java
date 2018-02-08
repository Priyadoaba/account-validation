package no.bank.account.exception;

public class InvalidAccountNumberException extends RuntimeException {

    private static final String defaultMessage = "Account number is invalid";

    public InvalidAccountNumberException(){
        super(defaultMessage);
    }

    public InvalidAccountNumberException(String message){
        super(message);
    }
}
