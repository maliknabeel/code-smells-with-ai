package com.codesmells.couplers.featureenvy.good;

/**
 * GOOD EXAMPLE: Product with Behavior
 * 
 * <h2>Refactoring Applied: Move Method</h2>
 * Moved price calculation logic from OrderService to Product.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Product is responsible for its own price calculation</li>
 *   <li>Encapsulation improved - internal details are hidden</li>
 *   <li>OrderService is less coupled to Product's internals</li>
 *   <li>Price logic can be reused easily</li>
 * </ul>
 */
public class Product {
    private String name;
    private double basePrice;
    private double discountRate;
    private double taxRate;
    
    public Product(String name, double basePrice, double discountRate, double taxRate) {
        this.name = name;
        this.basePrice = basePrice;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
    }
    
    /**
     * GOOD: Product calculates its own price
     */
    public double calculateFinalPrice() {
        double discount = basePrice * discountRate;
        double priceAfterDiscount = basePrice - discount;
        double tax = priceAfterDiscount * taxRate;
        return priceAfterDiscount + tax;
    }
    
    /**
     * GOOD: Product provides its own price breakdown
     */
    public String getPriceBreakdown() {
        double discount = basePrice * discountRate;
        double tax = (basePrice - discount) * taxRate;
        
        return String.format("Product: %s\nBase: $%.2f\nDiscount: $%.2f\nTax: $%.2f",
            name, basePrice, discount, tax);
    }
    
    public String getName() {
        return name;
    }
}
