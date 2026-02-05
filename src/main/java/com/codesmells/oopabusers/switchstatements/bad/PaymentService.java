package com.codesmells.oopabusers.switchstatements.bad;

import org.springframework.stereotype.Service;

/**
 * BAD EXAMPLE: Switch Statements Code Smell
 * 
 * <h2>What is Switch Statements Smell?</h2>
 * Complex switch or if-else-if chains that branch based on type codes or enums.
 * This is a sign that polymorphism should be used instead.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>Adding new payment types requires modifying this class</li>
 *   <li>Violates Open/Closed Principle</li>
 *   <li>Repeated switch statements for same type checking</li>
 *   <li>Type-specific behavior is scattered</li>
 *   <li>Easy to forget to update all switch statements</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use <b>Replace Conditional with Polymorphism</b> - Create a class hierarchy
 * where each type has its own class implementing a common interface.
 * 
 * @see com.codesmells.oopabusers.switchstatements.good for refactored version
 */
@Service
public class PaymentService {
    
    /**
     * BAD: Switch statement based on payment type
     * Adding a new payment type means modifying this method
     */
    public void processPayment(String paymentType, double amount) {
        switch (paymentType) {
            case "CREDIT_CARD":
                System.out.println("Processing credit card payment: $" + amount);
                applyTransactionFee(amount, 0.029); // 2.9% fee
                validateCreditCard();
                break;
            case "DEBIT_CARD":
                System.out.println("Processing debit card payment: $" + amount);
                applyTransactionFee(amount, 0.015); // 1.5% fee
                validateDebitCard();
                break;
            case "PAYPAL":
                System.out.println("Processing PayPal payment: $" + amount);
                applyTransactionFee(amount, 0.034); // 3.4% fee
                validatePayPalAccount();
                break;
            case "BITCOIN":
                System.out.println("Processing Bitcoin payment: $" + amount);
                applyTransactionFee(amount, 0.01); // 1% fee
                validateBitcoinWallet();
                break;
            default:
                throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
    }
    
    /**
     * BAD: Another switch on the same type - duplication
     */
    public String getPaymentDescription(String paymentType) {
        switch (paymentType) {
            case "CREDIT_CARD":
                return "Credit Card - Fast and secure";
            case "DEBIT_CARD":
                return "Debit Card - Direct bank transfer";
            case "PAYPAL":
                return "PayPal - Popular online payment";
            case "BITCOIN":
                return "Bitcoin - Cryptocurrency payment";
            default:
                return "Unknown payment method";
        }
    }
    
    /**
     * BAD: Yet another switch on the same type
     */
    public int getProcessingTime(String paymentType) {
        switch (paymentType) {
            case "CREDIT_CARD":
                return 1; // 1 day
            case "DEBIT_CARD":
                return 2; // 2 days
            case "PAYPAL":
                return 1; // 1 day
            case "BITCOIN":
                return 3; // 3 days (confirmation time)
            default:
                return 5;
        }
    }
    
    private void applyTransactionFee(double amount, double feeRate) {
        System.out.println("Transaction fee: $" + (amount * feeRate));
    }
    
    private void validateCreditCard() {
        System.out.println("Validating credit card...");
    }
    
    private void validateDebitCard() {
        System.out.println("Validating debit card...");
    }
    
    private void validatePayPalAccount() {
        System.out.println("Validating PayPal account...");
    }
    
    private void validateBitcoinWallet() {
        System.out.println("Validating Bitcoin wallet...");
    }
}
