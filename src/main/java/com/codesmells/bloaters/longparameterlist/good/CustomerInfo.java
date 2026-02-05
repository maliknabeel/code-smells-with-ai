package com.codesmells.bloaters.longparameterlist.good;

/**
 * GOOD: Customer info object
 */
public class CustomerInfo {
    private final String customerId;
    private final String name;
    private final String email;
    
    public CustomerInfo(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }
    
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
