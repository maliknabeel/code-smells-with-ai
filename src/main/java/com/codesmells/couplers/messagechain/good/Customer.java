package com.codesmells.couplers.messagechain.good;

/**
 * GOOD EXAMPLE: Hidden Delegate
 * 
 * <h2>Refactoring Applied: Hide Delegate</h2>
 * Added convenience methods to hide the internal structure.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>No message chains</li>
 *   <li>Client doesn't know about internal structure</li>
 *   <li>Can change internal structure without affecting clients</li>
 *   <li>Follows Law of Demeter</li>
 * </ul>
 */
public class Customer {
    private Address address;
    
    public Customer(Address address) {
        this.address = address;
    }
    
    /**
     * GOOD: Convenience method hides the chain
     * Clients can get zip code without knowing about Address and City
     */
    public String getZipCode() {
        return address.getZipCode();
    }
    
    // If needed, keep the original getter
    Address getAddress() {
        return address;
    }
}

class Address {
    private City city;
    
    public Address(City city) {
        this.city = city;
    }
    
    /**
     * GOOD: Convenience method to get zip code
     */
    public String getZipCode() {
        return city.getZipCode();
    }
    
    City getCity() {
        return city;
    }
}

class City {
    private String zipCode;
    
    public City(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public String getZipCode() {
        return zipCode;
    }
}
