package com.codesmells.dispensables.dataclass.good;

import org.springframework.stereotype.Service;

/**
 * GOOD: Service now just delegates to the account
 * Business logic is where it belongs - in BankAccount
 */
@Service
public class BankingService {
    
    /**
     * GOOD: "Telling" the account what to do, not manipulating its data
     */
    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }
    
    /**
     * GOOD: Delegation to the account's own behavior
     */
    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }
}
