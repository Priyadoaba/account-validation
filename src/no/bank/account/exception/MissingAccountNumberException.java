package no.bank.account.exception;

public class MissingAccountNumberException extends RuntimeException {

    private static final String defaultMessage = "Missing account number , It must be provided";

    public MissingAccountNumberException(){
        this(defaultMessage);
    }

    public MissingAccountNumberException(String message){
        super(message);
    }
}
