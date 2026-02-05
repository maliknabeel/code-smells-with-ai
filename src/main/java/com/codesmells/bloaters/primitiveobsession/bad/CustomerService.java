package com.codesmells.bloaters.primitiveobsession.bad;

import org.springframework.stereotype.Service;

/**
 * BAD EXAMPLE: Primitive Obsession Code Smell
 * 
 * <h2>What is Primitive Obsession?</h2>
 * Using primitive types (int, String, double, etc.) to represent domain concepts
 * instead of creating small objects for them. This leads to scattered validation,
 * business logic duplication, and unclear code.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>Email is just a String - no validation, can be invalid</li>
 *   <li>Phone number is just a String - could be any format</li>
 *   <li>Money amount is just a double - no currency information</li>
 *   <li>Validation logic is scattered throughout the code</li>
 *   <li>No type safety - can pass email where phone is expected</li>
 *   <li>Business rules (like email format) are not encapsulated</li>
 * </ul>
 * 
 * <h2>Warning Signs:</h2>
 * <ul>
 *   <li>Repeated validation of the same primitive values</li>
 *   <li>Comments like "must be in format..."</li>
 *   <li>Magic numbers and string patterns</li>
 *   <li>Multiple primitives always used together</li>
 * </ul>
 * 
 * @see com.codesmells.bloaters.primitiveobsession.good package for refactored version
 */
@Service
public class CustomerService {
    
    /**
     * BAD: All parameters are primitives, no domain objects
     * Email and phone are just strings with no validation or behavior
     */
    public void createCustomer(String customerId, String name, String email, 
                              String phone, double accountBalance, String currency) {
        // Validation scattered in method
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        if (phone == null || phone.length() < 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        
        if (accountBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency is required");
        }
        
        System.out.println("Creating customer: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Balance: " + accountBalance + " " + currency);
    }
    
    /**
     * BAD: Repeated email validation
     */
    public void updateEmail(String customerId, String newEmail) {
        if (newEmail == null || !newEmail.contains("@") || !newEmail.contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        System.out.println("Email updated to: " + newEmail);
    }
    
    /**
     * BAD: Money operations with primitives - easy to make mistakes
     */
    public double addFunds(double currentBalance, double amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return currentBalance + amount;
    }
    
    /**
     * BAD: No type safety - could pass phone where email is expected
     */
    public void sendNotification(String email, String phone, String message) {
        // No way to ensure email is actually an email and phone is a phone
        System.out.println("Sending to email: " + email);
        System.out.println("Sending to phone: " + phone);
    }
}
