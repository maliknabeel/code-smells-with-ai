package com.codesmells.oopabusers.switchstatements.good;

import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * GOOD EXAMPLE: Refactored using Polymorphism
 * 
 * <h2>Refactoring Applied: Replace Conditional with Polymorphism</h2>
 * Created a PaymentMethod interface with implementations for each payment type.
 * 
 * <h2>Benefits of this Refactoring:</h2>
 * <ul>
 *   <li>No switch statements - behavior is in the classes</li>
 *   <li>Easy to add new payment types - just create a new class</li>
 *   <li>Follows Open/Closed Principle - open for extension, closed for modification</li>
 *   <li>Each payment type is self-contained and testable</li>
 *   <li>Type-specific logic is encapsulated</li>
 * </ul>
 * 
 * <h2>Key Improvements:</h2>
 * <ul>
 *   <li>Adding Bitcoin payment? Just create BitcoinPayment class</li>
 *   <li>No need to modify existing code</li>
 *   <li>Each payment type has its own file</li>
 *   <li>Spring manages the payment method instances</li>
 * </ul>
 */
@Service
public class PaymentService {
    
    private final Map<String, PaymentMethod> paymentMethods;
    
    /**
     * GOOD: Spring automatically injects all PaymentMethod implementations
     * The map key is the bean name (e.g., "creditCard", "paypal")
     */
    public PaymentService(Map<String, PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
    
    /**
     * GOOD: No switch statement - delegates to the appropriate PaymentMethod
     */
    public void processPayment(String paymentType, double amount) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentType);
        paymentMethod.process(amount);
    }
    
    /**
     * GOOD: No switch statement - uses polymorphism
     */
    public String getPaymentDescription(String paymentType) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentType);
        return paymentMethod.getDescription();
    }
    
    /**
     * GOOD: No switch statement - uses polymorphism
     */
    public int getProcessingTime(String paymentType) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentType);
        return paymentMethod.getProcessingTime();
    }
    
    private PaymentMethod getPaymentMethod(String paymentType) {
        PaymentMethod method = paymentMethods.get(paymentType.toLowerCase());
        if (method == null) {
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
        return method;
    }
}
