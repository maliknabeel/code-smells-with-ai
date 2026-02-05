package com.codesmells.bloaters.longparameterlist.bad;

import org.springframework.stereotype.Service;

/**
 * BAD EXAMPLE: Long Parameter List Code Smell
 * 
 * <h2>What is Long Parameter List?</h2>
 * Methods with too many parameters (typically more than 3-4) that are hard to use
 * and understand. Often indicates missing abstractions.
 * 
 * <h2>Problems:</h2>
 * <ul>
 *   <li>Hard to remember parameter order</li>
 *   <li>Easy to pass parameters in wrong order</li>
 *   <li>Method signature is hard to read</li>
 *   <li>Adding new parameters requires changing all callers</li>
 * </ul>
 * 
 * @see com.codesmells.bloaters.longparameterlist.good for refactored version
 */
@Service
public class OrderService {
    
    /**
     * BAD: 10 parameters! Hard to use and error-prone
     */
    public void createOrder(String customerId, String customerName, String customerEmail,
                          String shippingStreet, String shippingCity, String shippingState, 
                          String shippingZip, String billingStreet, String billingCity,
                          String billingState) {
        System.out.println("Creating order for: " + customerName);
        System.out.println("Shipping to: " + shippingStreet + ", " + shippingCity);
        System.out.println("Billing to: " + billingStreet + ", " + billingCity);
    }
}
