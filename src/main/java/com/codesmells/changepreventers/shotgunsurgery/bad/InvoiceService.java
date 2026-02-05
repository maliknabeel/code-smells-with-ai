/**
 * BAD EXAMPLE: Shotgun Surgery
 * 
 * Yet another place with duplicated tax logic.
 * Centralization reduces maintenance overhead and errors.
 */
package com.codesmells.changepreventers.shotgunsurgery.bad;

public class InvoiceService {
    public double applyTax(double amount, String region) {
        double rate;
        if ("NE".equals(region)) {
            rate = 0.088;
        } else if ("WC".equals(region)) {
            rate = 0.093;
        } else {
            rate = 0.07;
        }
        return amount * (1 + rate);
    }
}
