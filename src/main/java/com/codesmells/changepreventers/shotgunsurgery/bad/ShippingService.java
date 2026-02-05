/**
 * BAD EXAMPLE: Shotgun Surgery
 * 
 * Duplicated tax logic. A tax change forces edits in multiple places.
 * Centralize the logic to one service to avoid shotgun surgery.
 */
package com.codesmells.changepreventers.shotgunsurgery.bad;

public class ShippingService {
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
