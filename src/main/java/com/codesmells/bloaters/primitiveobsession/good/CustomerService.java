package com.codesmells.bloaters.primitiveobsession.good;

import org.springframework.stereotype.Service;

/**
 * GOOD EXAMPLE: Refactored using Value Objects
 * 
 * <h2>Refactoring Applied: Replace Primitive with Object</h2>
 * Created value objects (Email, PhoneNumber, Money) to replace primitives.
 * 
 * <h2>Benefits of this Refactoring:</h2>
 * <ul>
 *   <li>Validation is centralized in value objects</li>
 *   <li>Type safety prevents mixing up values</li>
 *   <li>Business logic is encapsulated in domain objects</li>
 *   <li>Code is more expressive and self-documenting</li>
 *   <li>Easier to add behavior to domain concepts</li>
 *   <li>Prevents invalid objects from being created</li>
 * </ul>
 * 
 * <h2>Key Improvements:</h2>
 * <ul>
 *   <li>Cannot create invalid emails or phone numbers</li>
 *   <li>Money operations prevent currency mismatches</li>
 *   <li>Domain concepts are explicit in code</li>
 *   <li>Validation happens once at object creation</li>
 * </ul>
 * 
 * <h2>Teaching Points:</h2>
 * <ul>
 *   <li>Create value objects for domain concepts</li>
 *   <li>Make value objects immutable</li>
 *   <li>Validate in constructors</li>
 *   <li>Add domain-specific behavior to objects</li>
 * </ul>
 */
@Service
public class CustomerService {
    
    /**
     * GOOD: Uses value objects instead of primitives
     * Type safety ensures email is an email and phone is a phone number
     */
    public void createCustomer(String customerId, String name, Email email, 
                              PhoneNumber phone, Money accountBalance) {
        // No validation needed - value objects ensure validity
        System.out.println("Creating customer: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Balance: " + accountBalance);
    }
    
    /**
     * GOOD: Email validation is handled by Email class
     */
    public void updateEmail(String customerId, Email newEmail) {
        // Email is guaranteed to be valid
        System.out.println("Email updated to: " + newEmail);
        System.out.println("Domain: " + newEmail.getDomain());
    }
    
    /**
     * GOOD: Money object prevents currency mismatches
     */
    public Money addFunds(Money currentBalance, Money amount) {
        // Money.add() ensures currencies match
        return currentBalance.add(amount);
    }
    
    /**
     * GOOD: Type safety prevents mixing up email and phone
     */
    public void sendNotification(Email email, PhoneNumber phone, String message) {
        // Compiler ensures email is Email and phone is PhoneNumber
        System.out.println("Sending to email: " + email);
        System.out.println("Sending to phone: " + phone.getFormatted());
    }
}
