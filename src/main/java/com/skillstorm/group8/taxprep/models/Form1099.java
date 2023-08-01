package com.skillstorm.group8.taxprep.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "form1099s")
public class Form1099 {

    /* ATTRIBUTES */

    // Payer's Tax Identification Number (TIN)
    @Id
    private String payerTIN;

    // Reference to the user who filled the form
    private String email;

    private double amountEarned;

    // Amount withheld from income
    private double amountWithheld;

    // Business name
    private String businessName;

    // Employer's first name
    private String payerFirstName;

    // Employer's last name
    private String payerLastName;

    // Business address
    private Address address;


    /* CONSTRUCTORS */


    
    public Form1099(String payerTIN, String email, double amountEarned, double amountWithheld, String businessName) {
        this.payerTIN = payerTIN;
        this.email = email;
        this.amountEarned = amountEarned;
        this.amountWithheld = amountWithheld;
        this.businessName = businessName;
    }

    public Form1099() {
    }

    public Form1099(String payerTIN, String email, double amountEarned, double amountWithheld, String businessName,
            Address address) {
        this.payerTIN = payerTIN;
        this.email = email;
        this.amountEarned = amountEarned;
        this.amountWithheld = amountWithheld;
        this.businessName = businessName;
        this.address = address;
    }

    public Form1099(String payerTIN, String email, double amountEarned, double amountWithheld, String payerFirstName,
            String payerLastName) {
        this.payerTIN = payerTIN;
        this.email = email;
        this.amountEarned = amountEarned;
        this.amountWithheld = amountWithheld;
        this.payerFirstName = payerFirstName;
        this.payerLastName = payerLastName;
    }

    public Form1099(String payerTIN, String email, double amountEarned, double amountWithheld, String payerFirstName,
            String payerLastName, Address address) {
        this.payerTIN = payerTIN;
        this.email = email;
        this.amountEarned = amountEarned;
        this.amountWithheld = amountWithheld;
        this.payerFirstName = payerFirstName;
        this.payerLastName = payerLastName;
        this.address = address;
    }
    
    /* GETTERS AND SETTERS */

    public String getPayerTIN() {
        return payerTIN;
    }

    public void setPayerTIN(String payerTIN) {
        this.payerTIN = payerTIN;
    }

    public double getAmountWithheld() {
        return amountWithheld;
    }

    public void setAmountWithheld(double amountWithheld) {
        this.amountWithheld = amountWithheld;
    }

    public String getPayerFirstName() {
        return payerFirstName;
    }

    public void setPayerFirstName(String payerFirstName) {
        this.payerFirstName = payerFirstName;
    }

    public String getPayerLastName() {
        return payerLastName;
    }

    public void setPayerLastName(String payerLastName) {
        this.payerLastName = payerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmountEarned() {
        return amountEarned;
    }

    public void setAmountEarned(double amountEarned) {
        this.amountEarned = amountEarned;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /* HASHCODE AND EQUALS */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((payerTIN == null) ? 0 : payerTIN.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        long temp;
        temp = Double.doubleToLongBits(amountEarned);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(amountWithheld);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
        result = prime * result + ((payerFirstName == null) ? 0 : payerFirstName.hashCode());
        result = prime * result + ((payerLastName == null) ? 0 : payerLastName.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Form1099 other = (Form1099) obj;
        if (payerTIN == null) {
            if (other.payerTIN != null)
                return false;
        } else if (!payerTIN.equals(other.payerTIN))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (Double.doubleToLongBits(amountEarned) != Double.doubleToLongBits(other.amountEarned))
            return false;
        if (Double.doubleToLongBits(amountWithheld) != Double.doubleToLongBits(other.amountWithheld))
            return false;
        if (businessName == null) {
            if (other.businessName != null)
                return false;
        } else if (!businessName.equals(other.businessName))
            return false;
        if (payerFirstName == null) {
            if (other.payerFirstName != null)
                return false;
        } else if (!payerFirstName.equals(other.payerFirstName))
            return false;
        if (payerLastName == null) {
            if (other.payerLastName != null)
                return false;
        } else if (!payerLastName.equals(other.payerLastName))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }

    /* TO STRING */

    @Override
    public String toString() {
        return "Form1099 [payerTIN=" + payerTIN + ", email=" + email + ", amountEarned=" + amountEarned
                + ", amountWithheld=" + amountWithheld + ", businessName=" + businessName + ", payerFirstName="
                + payerFirstName + ", payerLastName=" + payerLastName + ", address=" + address + "]";
    }
}
