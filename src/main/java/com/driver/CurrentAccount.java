package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char licenceId[] = tradeLicenseId.toCharArray();

        for (int i = 1; i< licenceId.length; i+=2){
            if (licenceId[i] == licenceId[i-1]){
                for (int j = 0; j<26; j++){
                    char newChar = (char)('A' + j);
                    if(newChar != licenceId[i-1] && newChar != licenceId[i+1]){
                        licenceId[i] = newChar;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i< licenceId.length; i+=2){
            if (licenceId[i] == licenceId[i-1]){
                throw new Exception("Valid License can not be generated");
            }
        }
    }

}
