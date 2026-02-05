package com.codesmells.oopabusers.switchstatements.good;

/**
 * GOOD: Payment method interface using polymorphism
 */
public interface PaymentMethod {
    void process(double amount);
    String getDescription();
    int getProcessingTime();
}
