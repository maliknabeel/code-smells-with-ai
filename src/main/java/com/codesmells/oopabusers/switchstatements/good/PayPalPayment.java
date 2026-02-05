package com.codesmells.oopabusers.switchstatements.good;

import org.springframework.stereotype.Component;

/**
 * GOOD: PayPal payment implementation
 */
@Component("paypal")
public class PayPalPayment implements PaymentMethod {
    
    @Override
    public void process(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
        applyTransactionFee(amount);
        validatePayPalAccount();
    }
    
    @Override
    public String getDescription() {
        return "PayPal - Popular online payment";
    }
    
    @Override
    public int getProcessingTime() {
        return 1; // 1 day
    }
    
    private void applyTransactionFee(double amount) {
        System.out.println("Transaction fee: $" + (amount * 0.034)); // 3.4%
    }
    
    private void validatePayPalAccount() {
        System.out.println("Validating PayPal account...");
    }
}
