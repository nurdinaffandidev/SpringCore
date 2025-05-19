package com.nurdinaffandidev.springCore.models;

public class Address {
    // Attributes
    private String city;
    private String country;

    // Constructor
    public Address() {
        super();
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // Getter Setter
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Methods
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
