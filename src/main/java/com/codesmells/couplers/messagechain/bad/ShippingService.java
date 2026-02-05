package com.codesmells.couplers.messagechain.bad;

import org.springframework.stereotype.Service;

/**
 * BAD EXAMPLE: Message Chains Code Smell
 * 
 * <h2>What are Message Chains?</h2>
 * Long chains of method calls like a.b().c().d(), where a client asks one object
 * for another object, then asks that object for another, and so on.
 * Also known as "Train Wreck" code.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>customer.getAddress().getCity().getZipCode() - too many calls</li>
 *   <li>Client knows too much about object structure</li>
 *   <li>Violates Law of Demeter (principle of least knowledge)</li>
 *   <li>Fragile - if structure changes, all chains break</li>
 *   <li>Hard to test - need to mock entire chain</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use <b>Hide Delegate</b> to create convenience methods that hide the chains.
 * 
 * @see com.codesmells.couplers.messagechain.good for refactored version
 */
@Service
public class ShippingService {
    
    /**
     * BAD: Message chain violating Law of Demeter
     * This code knows too much about Customer's internal structure
     */
    public double calculateShippingCost(Customer customer, double weight) {
        // BAD: Chain of method calls
        String zipCode = customer.getAddress().getCity().getZipCode();
        
        // Shipping cost based on zip code
        if (zipCode.startsWith("0")) {
            return weight * 2.5; // Northeast
        } else if (zipCode.startsWith("9")) {
            return weight * 3.0; // West Coast
        }
        return weight * 2.0; // Other regions
    }
    
    /**
     * BAD: Another message chain on the same structure
     */
    public boolean isLocalDelivery(Customer customer) {
        // BAD: Same chain repeated
        String zipCode = customer.getAddress().getCity().getZipCode();
        return zipCode.startsWith("12"); // Local area code
    }
}
