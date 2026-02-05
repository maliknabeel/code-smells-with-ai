/**
 * BAD EXAMPLE: Shotgun Surgery
 * 
 * Tax calculation logic is duplicated here and in other classes.
 * Changing tax rates requires editing many files, increasing risk.
 * Refactor by centralizing the logic in a dedicated service.
 */
package com.codesmells.changepreventers.shotgunsurgery.bad;

public class PaymentService {
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
