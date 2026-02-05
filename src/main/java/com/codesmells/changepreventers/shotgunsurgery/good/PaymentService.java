/**
 * GOOD: Delegates tax calculation to TaxService.
 * 
 * Clients use this class without knowing tax details,
 * which are maintained centrally.
 */
package com.codesmells.changepreventers.shotgunsurgery.good;

public class PaymentService {
    private final TaxService taxService;

    public PaymentService(TaxService taxService) {
        this.taxService = taxService;
    }

    public double applyTax(double amount, String region) {
        return taxService.applyTax(amount, region);
    }
}
