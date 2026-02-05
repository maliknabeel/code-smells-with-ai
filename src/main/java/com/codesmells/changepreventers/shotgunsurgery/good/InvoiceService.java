/**
 * GOOD: Delegates tax calculation to TaxService.
 * 
 * Only this service's orchestration remains; tax logic is centralized.
 */
package com.codesmells.changepreventers.shotgunsurgery.good;

public class InvoiceService {
    private final TaxService taxService;

    public InvoiceService(TaxService taxService) {
        this.taxService = taxService;
    }

    public double applyTax(double amount, String region) {
        return taxService.applyTax(amount, region);
    }
}
