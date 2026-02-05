package com.codesmells.couplers.messagechain.bad;

/**
 * BAD: Complex object structure with chains
 */
public class Customer {
    private Address address;
    
    public Customer(Address address) {
        this.address = address;
    }
    
    public Address getAddress() {
        return address;
    }
}

class Address {
    private City city;
    
    public Address(City city) {
        this.city = city;
    }
    
    public City getCity() {
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
