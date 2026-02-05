package com.codesmells.dispensables.dataclass.good;

/**
 * GOOD EXAMPLE: Data Class with Behavior
 * 
 * <h2>Refactoring Applied: Move Method</h2>
 * Moved business logic from BankingService into BankAccount.
 * 
 * <h2>Benefits of this Refactoring:</h2>
 * <ul>
 *   <li>Business logic is encapsulated in the class that owns the data</li>
 *   <li>Follows "Tell, Don't Ask" principle</li>
 *   <li>Data and behavior are together</li>
 *   <li>Easier to maintain - all account logic is in one place</li>
 *   <li>Better encapsulation</li>
 * </ul>
 * 
 * <h2>Key Improvements:</h2>
 * <ul>
 *   <li>BankAccount now has behavior, not just data</li>
 *   <li>Withdrawal limits are encapsulated</li>
 *   <li>Cannot manipulate balance directly from outside</li>
 *   <li>Validation is built into the methods</li>
 * </ul>
 */
public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final String accountType;
    
    public BankAccount(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    
    /**
     * GOOD: Deposit behavior is encapsulated in the account
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " to account " + accountNumber);
    }
    
    /**
     * GOOD: Withdrawal behavior is encapsulated with validation
     */
    public void withdraw(double amount) {
        validateWithdrawal(amount);
        balance -= amount;
        System.out.println("Withdrew $" + amount + " from account " + accountNumber);
    }
    
    /**
     * GOOD: Validation is part of the account's behavior
     */
    private void validateWithdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        if (amount > getWithdrawalLimit()) {
            throw new IllegalArgumentException("Amount exceeds withdrawal limit of $" + getWithdrawalLimit());
        }
    }
    
    /**
     * GOOD: Account type logic is encapsulated
     */
    private double getWithdrawalLimit() {
        return switch (accountType) {
            case "SAVINGS" -> 500;
            case "CHECKING" -> 1000;
            default -> 100;
        };
    }
    
    // Read-only accessors - balance cannot be set from outside
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
}
