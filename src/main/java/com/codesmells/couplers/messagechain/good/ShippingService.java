package com.codesmells.couplers.messagechain.good;

import org.springframework.stereotype.Service;

/**
 * GOOD: No message chains - uses convenient methods
 */
@Service
public class ShippingService {
    
    /**
     * GOOD: No chain - just one method call
     * Don't know about Address or City - just ask Customer
     */
    public double calculateShippingCost(Customer customer, double weight) {
        String zipCode = customer.getZipCode(); // Clean, simple
        
        if (zipCode.startsWith("0")) {
            return weight * 2.5;
        } else if (zipCode.startsWith("9")) {
            return weight * 3.0;
        }
        return weight * 2.0;
    }
    
    /**
     * GOOD: Simple, direct call
     */
    public boolean isLocalDelivery(Customer customer) {
        String zipCode = customer.getZipCode();
        return zipCode.startsWith("12");
    }
}
