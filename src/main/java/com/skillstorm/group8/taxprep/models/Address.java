package com.skillstorm.group8.taxprep.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {

    /* ATTRIBUTES */

    // Primary key
    @Id
    private int id;

    // Primary street address
    private String streetPrimary;

    // Secondary street address
    private String streetSecondary;

    // City
    private String city;

    // State
    private String state;

    // Zip code
    private Integer zipCode;
    
    /* CONSTRUCTORS */

    public Address() {
        // Default constructor
    }

    /* GETTERS AND SETTERS */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetPrimary() {
        return streetPrimary;
    }

    public void setStreetPrimary(String streetPrimary) {
        this.streetPrimary = streetPrimary;
    }

    public String getStreetSecondary() {
        return streetSecondary;
    }

    public void setStreetSecondary(String streetSecondary) {
        this.streetSecondary = streetSecondary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Address(int id, String streetPrimary, String streetSecondary, String city, String state, Integer zipCode) {
        this.id = id;
        this.streetPrimary = streetPrimary;
        this.streetSecondary = streetSecondary;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(int id, String streetPrimary, String city, String state, Integer zipCode) {
        this.id = id;
        this.streetPrimary = streetPrimary;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}
