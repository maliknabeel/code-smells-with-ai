package com.codesmells.dispensables.dataclass.bad;

import org.springframework.stereotype.Service;

/**
 * BAD: This service manipulates BankAccount's data directly
 * The business logic should be in BankAccount itself
 */
@Service
public class BankingService {
    
    /**
     * BAD: "Asking" the account for its data and manipulating it externally
     */
    public void deposit(BankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        System.out.println("Deposited $" + amount);
    }
    
    /**
     * BAD: Account's business logic is here, not in the account class
     */
    public void withdraw(BankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        
        // BAD: Withdrawal limits logic outside the account
        double withdrawalLimit = getWithdrawalLimit(account);
        if (amount > withdrawalLimit) {
            throw new IllegalArgumentException("Amount exceeds withdrawal limit");
        }
        
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        System.out.println("Withdrew $" + amount);
    }
    
    /**
     * BAD: Account type logic should be in the account
     */
    private double getWithdrawalLimit(BankAccount account) {
        if (account.getAccountType().equals("SAVINGS")) {
            return 500;
        } else if (account.getAccountType().equals("CHECKING")) {
            return 1000;
        }
        return 100;
    }
}
