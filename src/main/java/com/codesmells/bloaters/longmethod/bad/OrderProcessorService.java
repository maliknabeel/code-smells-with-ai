package com.codesmells.bloaters.longmethod.bad;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

/**
 * BAD EXAMPLE: Long Method Code Smell
 * 
 * <h2>What is Long Method?</h2>
 * A Long Method is a method that has grown too large and tries to do too many things.
 * As a rule of thumb, if a method has more than 10-15 lines, it might be too long.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>The processOrder method is over 60 lines long</li>
 *   <li>It handles multiple responsibilities: validation, calculation, discount, tax, shipping, notification</li>
 *   <li>Hard to understand what the method does at a glance</li>
 *   <li>Difficult to test individual parts</li>
 *   <li>Hard to reuse logic in other contexts</li>
 *   <li>Violates Single Responsibility Principle</li>
 * </ul>
 * 
 * <h2>Warning Signs:</h2>
 * <ul>
 *   <li>Method requires scrolling to see all code</li>
 *   <li>Multiple levels of nested loops or conditionals</li>
 *   <li>Many local variables</li>
 *   <li>Comments needed to explain different sections</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use the <b>Extract Method</b> refactoring technique to break down the large method
 * into smaller, focused methods that each do one thing well.
 * 
 * @see com.codesmells.bloaters.longmethod.good.OrderProcessorService for the refactored version
 */
@Service
public class OrderProcessorService {

    /**
     * BAD: This method is way too long and does too many things
     * It violates the Single Responsibility Principle
     */
    public double processOrder(String customerId, List<String> items, String shippingAddress) {
        // Validate customer
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        
        // Validate items
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        
        // Validate shipping address
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            throw new IllegalArgumentException("Shipping address cannot be null or empty");
        }
        
        // Calculate subtotal
        double subtotal = 0;
        List<Double> itemPrices = new ArrayList<>();
        for (String item : items) {
            double price = 0;
            // Simulate getting price from database
            if (item.equals("ITEM001")) {
                price = 29.99;
            } else if (item.equals("ITEM002")) {
                price = 49.99;
            } else if (item.equals("ITEM003")) {
                price = 19.99;
            } else {
                price = 9.99;
            }
            itemPrices.add(price);
            subtotal += price;
        }
        
        // Apply discount based on customer loyalty
        double discount = 0;
        // Simulate getting customer loyalty level
        String loyaltyLevel = "GOLD"; // This would come from database
        if (loyaltyLevel.equals("GOLD")) {
            discount = subtotal * 0.15; // 15% discount
        } else if (loyaltyLevel.equals("SILVER")) {
            discount = subtotal * 0.10; // 10% discount
        } else if (loyaltyLevel.equals("BRONZE")) {
            discount = subtotal * 0.05; // 5% discount
        }
        
        double afterDiscount = subtotal - discount;
        
        // Calculate tax based on shipping address
        double tax = 0;
        if (shippingAddress.contains("CA")) {
            tax = afterDiscount * 0.0875; // California tax
        } else if (shippingAddress.contains("NY")) {
            tax = afterDiscount * 0.08875; // New York tax
        } else if (shippingAddress.contains("TX")) {
            tax = afterDiscount * 0.0625; // Texas tax
        } else {
            tax = afterDiscount * 0.05; // Default tax
        }
        
        // Calculate shipping cost
        double shippingCost = 0;
        int itemCount = items.size();
        if (itemCount <= 2) {
            shippingCost = 5.99;
        } else if (itemCount <= 5) {
            shippingCost = 8.99;
        } else {
            shippingCost = 12.99;
        }
        
        // Free shipping for orders over $100
        if (afterDiscount >= 100) {
            shippingCost = 0;
        }
        
        double total = afterDiscount + tax + shippingCost;
        
        // Send confirmation email
        System.out.println("Sending email to customer: " + customerId);
        System.out.println("Order Details:");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Tax: $" + tax);
        System.out.println("Shipping: $" + shippingCost);
        System.out.println("Total: $" + total);
        
        // Log the order
        System.out.println("Order logged for customer: " + customerId);
        
        return total;
    }
}
