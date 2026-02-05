package com.codesmells.bloaters.longparameterlist.good;

import org.springframework.stereotype.Service;

/**
 * GOOD EXAMPLE: Refactored using Parameter Objects
 * 
 * <h2>Refactoring Applied: Introduce Parameter Object</h2>
 * Grouped related parameters into objects.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Method signature is clean and readable</li>
 *   <li>Parameter objects can be reused</li>
 *   <li>Type safety prevents parameter mix-ups</li>
 *   <li>Easy to add new fields to parameter objects</li>
 * </ul>
 */
@Service
public class OrderService {
    
    /**
     * GOOD: Only 3 meaningful parameters
     */
    public void createOrder(CustomerInfo customer, Address shipping, Address billing) {
        System.out.println("Creating order for: " + customer.getName());
        System.out.println("Shipping to: " + shipping);
        System.out.println("Billing to: " + billing);
    }
}
