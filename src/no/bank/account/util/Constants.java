package no.bank.account.util;

public interface Constants {

    String VALID_ACCOUNT_NUMBER_REGEX = "^\\d{4}.\\d{2}.\\d{5}$";

    int VALID_ACCOUNT_NUMBER_LENGTH = 11;

    String AMBIGUOUS_CHECK_DIGIT = "-";
}
