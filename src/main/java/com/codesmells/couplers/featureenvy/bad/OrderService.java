package com.codesmells.couplers.featureenvy.bad;

import org.springframework.stereotype.Service;

/**
 * BAD EXAMPLE: Feature Envy Code Smell
 * 
 * <h2>What is Feature Envy?</h2>
 * A method that uses more features (methods and fields) of another class
 * than its own class. It "envies" the other class's features.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>calculateTotalPrice() uses Product's data extensively</li>
 *   <li>Price calculation logic should be in Product, not here</li>
 *   <li>Makes Product a dumb data holder</li>
 *   <li>OrderService is too coupled to Product's internals</li>
 *   <li>Difficult to reuse price calculation logic</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use <b>Move Method</b> to move calculateTotalPrice() to Product class.
 * 
 * @see com.codesmells.couplers.featureenvy.good for refactored version
 */
@Service
public class OrderService {
    
    /**
     * BAD: This method is more interested in Product's data than OrderService's
     * It uses 4 methods from Product but none from OrderService
     */
    public double calculateTotalPrice(Product product, int quantity) {
        // Feature envy: using Product's features extensively
        double basePrice = product.getBasePrice();
        double discount = basePrice * product.getDiscountRate();
        double priceAfterDiscount = basePrice - discount;
        double tax = priceAfterDiscount * product.getTaxRate();
        double finalPrice = priceAfterDiscount + tax;
        
        return finalPrice * quantity;
    }
    
    /**
     * BAD: Another method envying Product's features
     */
    public String getProductPriceBreakdown(Product product) {
        double basePrice = product.getBasePrice();
        double discount = basePrice * product.getDiscountRate();
        double tax = (basePrice - discount) * product.getTaxRate();
        
        return String.format("Product: %s\nBase: $%.2f\nDiscount: $%.2f\nTax: $%.2f",
            product.getName(), basePrice, discount, tax);
    }
}
