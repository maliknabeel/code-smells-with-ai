package com.codesmells.bloaters.primitiveobsession.good;

/**
 * GOOD: Value Object for Email
 * Encapsulates email validation and behavior
 */
public class Email {
    private final String value;
    
    public Email(String value) {
        if (value == null || !isValid(value)) {
            throw new IllegalArgumentException("Invalid email format: " + value);
        }
        this.value = value;
    }
    
    private boolean isValid(String email) {
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".");
    }
    
    public String getValue() {
        return value;
    }
    
    public String getDomain() {
        return value.substring(value.indexOf("@") + 1);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Email)) return false;
        Email other = (Email) obj;
        return value.equals(other.value);
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
