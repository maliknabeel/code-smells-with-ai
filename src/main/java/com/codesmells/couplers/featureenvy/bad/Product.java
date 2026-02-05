package com.codesmells.couplers.featureenvy.bad;

/**
 * BAD: Product class - just a data holder
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
    
    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
    public double getDiscountRate() { return discountRate; }
    public double getTaxRate() { return taxRate; }
}
