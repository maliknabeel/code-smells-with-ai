package com.codesmells.bloaters.primitiveobsession.good;

/**
 * GOOD: Value Object for Phone Number
 * Encapsulates phone number validation and formatting
 */
public class PhoneNumber {
    private final String value;
    
    public PhoneNumber(String value) {
        if (value == null || !isValid(value)) {
            throw new IllegalArgumentException("Invalid phone number: " + value);
        }
        this.value = normalize(value);
    }
    
    private boolean isValid(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");
        return digits.length() >= 10 && digits.length() <= 15;
    }
    
    private String normalize(String phone) {
        return phone.replaceAll("[^0-9]", "");
    }
    
    public String getValue() {
        return value;
    }
    
    public String getFormatted() {
        if (value.length() == 10) {
            return String.format("(%s) %s-%s", 
                value.substring(0, 3), 
                value.substring(3, 6), 
                value.substring(6));
        }
        return value;
    }
    
    @Override
    public String toString() {
        return getFormatted();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PhoneNumber)) return false;
        PhoneNumber other = (PhoneNumber) obj;
        return value.equals(other.value);
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
