package com.skillstorm.group8.taxprep.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESSES")
public class Address {

    /* ATTRIBUTES */

    // Primary key
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Primary street address
    @Column(name = "street_primary")
    private String streetPrimary;

    // Secondary street address
    @Column(name = "street_secondary")
    private String streetSecondary;

    // City
    @Column(name = "city")
    private String city;

    // State
    @Column(name = "state")
    private String state;

    // Zip code
    @Column(name = "zip_code")
    private int zipCode;
    
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

}
