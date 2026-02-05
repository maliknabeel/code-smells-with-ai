package com.codesmells.dispensables.dataclass.bad;

/**
 * BAD EXAMPLE: Data Class Code Smell
 * 
 * <h2>What is a Data Class?</h2>
 * A class that only contains fields and getters/setters, with no real behavior.
 * It's just a container for data, missing opportunities for encapsulation.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>No business logic - just data storage</li>
 *   <li>Other classes manipulate this class's data</li>
 *   <li>Missed opportunity for encapsulation</li>
 *   <li>Violates "Tell, Don't Ask" principle</li>
 *   <li>Business rules are scattered in other classes</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use <b>Move Method</b> to move behavior that operates on this data into this class.
 * 
 * @see com.codesmells.dispensables.dataclass.good.BankAccount for refactored version
 */
public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountType;
    
    public BankAccount(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    
    // BAD: Only getters and setters, no behavior
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
