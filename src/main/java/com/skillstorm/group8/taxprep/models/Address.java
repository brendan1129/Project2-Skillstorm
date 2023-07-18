package com.skillstorm.group8.taxprep.models;

public class Address {

    private String streetPrimary;
    private String streetSecondary;
    private String city;
    private String state;
    private int zipCode;
    
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
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    
}
