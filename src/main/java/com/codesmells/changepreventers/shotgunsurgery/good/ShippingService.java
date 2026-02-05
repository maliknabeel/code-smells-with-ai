/**
 * GOOD: Delegates tax calculation to TaxService.
 * 
 * Demonstrates removing duplication across services.
 */
package com.codesmells.changepreventers.shotgunsurgery.good;

public class ShippingService {
    private final TaxService taxService;

    public ShippingService(TaxService taxService) {
        this.taxService = taxService;
    }

    public double applyTax(double amount, String region) {
        return taxService.applyTax(amount, region);
    }
}
