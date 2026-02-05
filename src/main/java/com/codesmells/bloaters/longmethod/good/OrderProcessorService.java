package com.codesmells.bloaters.longmethod.good;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

/**
 * GOOD EXAMPLE: Refactored Long Method
 * 
 * <h2>Refactoring Applied: Extract Method</h2>
 * The original long method has been broken down into smaller, focused methods.
 * Each method now has a single, clear responsibility.
 * 
 * <h2>Benefits of this Refactoring:</h2>
 * <ul>
 *   <li>Each method is short and easy to understand</li>
 *   <li>Methods can be tested independently</li>
 *   <li>Logic can be reused in other contexts</li>
 *   <li>Easier to modify individual pieces</li>
 *   <li>Better adherence to Single Responsibility Principle</li>
 *   <li>Self-documenting - method names explain what they do</li>
 * </ul>
 * 
 * <h2>Key Improvements:</h2>
 * <ul>
 *   <li>Validation extracted to separate methods</li>
 *   <li>Calculations extracted to focused methods</li>
 *   <li>Business rules isolated and reusable</li>
 *   <li>Main method now reads like a high-level algorithm</li>
 * </ul>
 * 
 * <h2>Teaching Points:</h2>
 * <ul>
 *   <li>Method names should describe what they do</li>
 *   <li>Keep methods focused on one task</li>
 *   <li>If you need comments to explain sections, extract those sections to methods</li>
 *   <li>Aim for methods under 15 lines</li>
 * </ul>
 */
@Service
public class OrderProcessorService {

    /**
     * GOOD: Main method is now short and readable, delegating to focused helper methods
     * It reads like a high-level algorithm, making the business process clear
     */
    public double processOrder(String customerId, List<String> items, String shippingAddress) {
        validateOrder(customerId, items, shippingAddress);
        
        double subtotal = calculateSubtotal(items);
        double discount = calculateDiscount(customerId, subtotal);
        double afterDiscount = subtotal - discount;
        double tax = calculateTax(shippingAddress, afterDiscount);
        double shippingCost = calculateShipping(items.size(), afterDiscount);
        double total = afterDiscount + tax + shippingCost;
        
        sendConfirmationEmail(customerId, subtotal, discount, tax, shippingCost, total);
        logOrder(customerId);
        
        return total;
    }

    /**
     * Validates all order inputs
     * Throws IllegalArgumentException if any validation fails
     */
    private void validateOrder(String customerId, List<String> items, String shippingAddress) {
        validateCustomerId(customerId);
        validateItems(items);
        validateShippingAddress(shippingAddress);
    }

    /**
     * Validates customer ID is not null or empty
     */
    private void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
    }

    /**
     * Validates items list contains at least one item
     */
    private void validateItems(List<String> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
    }

    /**
     * Validates shipping address is not null or empty
     */
    private void validateShippingAddress(String shippingAddress) {
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            throw new IllegalArgumentException("Shipping address cannot be null or empty");
        }
    }

    /**
     * Calculates the subtotal of all items in the order
     * @param items List of item IDs
     * @return Subtotal before discounts and taxes
     */
    private double calculateSubtotal(List<String> items) {
        double subtotal = 0;
        for (String item : items) {
            subtotal += getItemPrice(item);
        }
        return subtotal;
    }

    /**
     * Gets the price for a single item
     * In a real application, this would query a database
     */
    private double getItemPrice(String itemId) {
        return switch (itemId) {
            case "ITEM001" -> 29.99;
            case "ITEM002" -> 49.99;
            case "ITEM003" -> 19.99;
            default -> 9.99;
        };
    }

    /**
     * Calculates discount based on customer loyalty level
     * @param customerId Customer identifier
     * @param subtotal Order subtotal
     * @return Discount amount
     */
    private double calculateDiscount(String customerId, double subtotal) {
        String loyaltyLevel = getCustomerLoyaltyLevel(customerId);
        double discountRate = getDiscountRate(loyaltyLevel);
        return subtotal * discountRate;
    }

    /**
     * Gets customer loyalty level from database
     * In a real application, this would query a database
     */
    private String getCustomerLoyaltyLevel(String customerId) {
        // Simulated database lookup
        return "GOLD";
    }

    /**
     * Determines discount rate based on loyalty level
     */
    private double getDiscountRate(String loyaltyLevel) {
        return switch (loyaltyLevel) {
            case "GOLD" -> 0.15;    // 15% discount
            case "SILVER" -> 0.10;  // 10% discount
            case "BRONZE" -> 0.05;  // 5% discount
            default -> 0.0;
        };
    }

    /**
     * Calculates tax based on shipping address location
     * @param shippingAddress Address to ship to
     * @param amount Amount to calculate tax on
     * @return Tax amount
     */
    private double calculateTax(String shippingAddress, double amount) {
        double taxRate = getTaxRate(shippingAddress);
        return amount * taxRate;
    }

    /**
     * Determines tax rate based on state in shipping address
     */
    private double getTaxRate(String shippingAddress) {
        if (shippingAddress.contains("CA")) {
            return 0.0875;   // California
        } else if (shippingAddress.contains("NY")) {
            return 0.08875;  // New York
        } else if (shippingAddress.contains("TX")) {
            return 0.0625;   // Texas
        }
        return 0.05;         // Default
    }

    /**
     * Calculates shipping cost based on item count and order value
     * @param itemCount Number of items in order
     * @param orderValue Order value after discount
     * @return Shipping cost
     */
    private double calculateShipping(int itemCount, double orderValue) {
        // Free shipping for orders over $100
        if (orderValue >= 100) {
            return 0;
        }
        
        return getShippingRate(itemCount);
    }

    /**
     * Determines base shipping rate based on item count
     */
    private double getShippingRate(int itemCount) {
        if (itemCount <= 2) {
            return 5.99;
        } else if (itemCount <= 5) {
            return 8.99;
        }
        return 12.99;
    }

    /**
     * Sends order confirmation email to customer
     */
    private void sendConfirmationEmail(String customerId, double subtotal, 
                                      double discount, double tax, 
                                      double shippingCost, double total) {
        System.out.println("Sending email to customer: " + customerId);
        System.out.println("Order Details:");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Tax: $" + tax);
        System.out.println("Shipping: $" + shippingCost);
        System.out.println("Total: $" + total);
    }

    /**
     * Logs the order for audit purposes
     */
    private void logOrder(String customerId) {
        System.out.println("Order logged for customer: " + customerId);
    }
}
