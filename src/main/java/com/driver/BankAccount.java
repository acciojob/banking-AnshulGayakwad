package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0 || sum < 0 || digits*9 < sum) {
            throw new Exception("Account Number can not be generated");
        }
        //test case
        // digit > 4
        //sum > 12
        //possible ans > 0039, 0093, 1237, etc
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();
        int remainingSum = sum;
        for (int i = 0; i < digits - 1; i++) {
            int maxDigit = Math.min(remainingSum, 9);
            int digit = random.nextInt(maxDigit) + 1; // Adding 1 to avoid a digit of 0
            accountNumber.append(digit);
            remainingSum -= digit;
        }

        accountNumber.append(remainingSum);

        return accountNumber.toString();
        //return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - amount < minBalance){
            throw new Exception("Insufficient Balance");
        }
        else{
            balance -= amount;
        }
    }

}