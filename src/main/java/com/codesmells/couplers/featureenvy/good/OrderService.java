package com.codesmells.couplers.featureenvy.good;

import org.springframework.stereotype.Service;

/**
 * GOOD: OrderService now delegates to Product
 * No feature envy - just using Product's public interface
 */
@Service
public class OrderService {
    
    /**
     * GOOD: Simply delegates to Product and applies quantity
     */
    public double calculateTotalPrice(Product product, int quantity) {
        return product.calculateFinalPrice() * quantity;
    }
    
    /**
     * GOOD: Delegates to Product's method
     */
    public String getProductPriceBreakdown(Product product) {
        return product.getPriceBreakdown();
    }
}
