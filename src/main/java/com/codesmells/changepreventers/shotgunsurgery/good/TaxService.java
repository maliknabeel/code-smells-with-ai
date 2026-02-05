/**
 * GOOD EXAMPLE: Centralized Tax Service
 * 
 * Single source of truth for tax rates and calculations.
 * Changing tax rules is done here, avoiding edits across many classes.
 */
package com.codesmells.changepreventers.shotgunsurgery.good;

public class TaxService {
    public double applyTax(double amount, String region) {
        return amount * (1 + getRate(region));
    }

    public double getRate(String region) {
        return switch (region) {
            case "NE" -> 0.088;
            case "WC" -> 0.093;
            default -> 0.07;
        };
    }
}
