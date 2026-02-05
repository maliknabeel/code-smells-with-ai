package com.codesmells.bloaters.primitiveobsession.good;

/**
 * GOOD: Value Object for Money
 * Encapsulates money operations with proper decimal handling and currency
 */
public class Money {
    private final double amount;
    private final String currency;
    
    public Money(double amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency is required");
        }
        this.amount = amount;
        this.currency = currency.toUpperCase();
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return new Money(this.amount + other.amount, this.currency);
    }
    
    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot subtract money with different currencies");
        }
        return new Money(this.amount - other.amount, this.currency);
    }
    
    public boolean isGreaterThan(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot compare money with different currencies");
        }
        return this.amount > other.amount;
    }
    
    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money other = (Money) obj;
        return Double.compare(amount, other.amount) == 0 && currency.equals(other.currency);
    }
    
    @Override
    public int hashCode() {
        return Double.hashCode(amount) * 31 + currency.hashCode();
    }
}
