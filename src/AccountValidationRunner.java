import no.bank.account.Account;

import java.util.Scanner;

public class AccountValidationRunner{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Please enter norwegian bank account number(xxxx.yy.zzzzz) : ");
                String accountUnderTest = scanner.next();
                //String accountUnderTest = "1234.56.78903";
                //System.out.println("account number under test: "+ accountUnderTest);
                System.out.println("Given account number is " + (new Account(accountUnderTest).isValidModulo()? "valid":"invalid"));
            }catch (Exception e){
                System.err.println("Error occurred: "+ e.getMessage());
            }
            System.out.println("do you want to continue(Y/N)");
            String proceed = scanner.next();
            if(!proceed.equalsIgnoreCase("Y")){
                break;
            }
        }
    }

}
