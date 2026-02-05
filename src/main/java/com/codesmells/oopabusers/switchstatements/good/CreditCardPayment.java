package com.codesmells.oopabusers.switchstatements.good;

import org.springframework.stereotype.Component;

/**
 * GOOD: Credit Card payment implementation
 */
@Component("creditCard")
public class CreditCardPayment implements PaymentMethod {
    
    @Override
    public void process(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
        applyTransactionFee(amount);
        validateCreditCard();
    }
    
    @Override
    public String getDescription() {
        return "Credit Card - Fast and secure";
    }
    
    @Override
    public int getProcessingTime() {
        return 1; // 1 day
    }
    
    private void applyTransactionFee(double amount) {
        System.out.println("Transaction fee: $" + (amount * 0.029)); // 2.9%
    }
    
    private void validateCreditCard() {
        System.out.println("Validating credit card...");
    }
}
