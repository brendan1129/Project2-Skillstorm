package com.skillstorm.group8.taxprep.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.skillstorm.group8.taxprep.services.Form1099Service;
import com.skillstorm.group8.taxprep.services.FormW2Service;
import com.skillstorm.group8.taxprep.services.UserService;

@Document(collection="taxforms")
public class TaxForms {

    @Autowired
    UserService userService;

    @Autowired
    FormW2Service formW2Service;

    @Autowired
    Form1099Service form1099Service;

    /* ATTRIBUTES */

    @Id
    // User's email/login
    String email;

    // Year of tax filing
    int year;

    // Total earnings
    double earned;

    // Total witholdings
    double withheld;

    // How much the user owe's or is getting refunded for the current tax year
    double result;


    /* CONSTRUCTORS */

    public TaxForms() {
        // Default constructor
    }


    public TaxForms(String email) {
        this.email = email;
    }


    public TaxForms(String email, int year, double earned, double withheld, double result) {
        this.email = email;
        this.year = year;
        this.earned = earned;
        this.withheld = withheld;
        this.result = result;
    }


    /* GETTERS AND SETTERS */

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public double getEarned() {
        return earned;
    }


    public void setEarned(double earned) {
        this.earned = earned;
    }


    public double getWithheld() {
        return withheld;
    }


    public void setWithheld(double withheld) {
        this.withheld = withheld;
    }


    public double getResult() {
        return result;
    }


    public void setResult(double result) {
        this.result = result;
    }

    /* HASHCODE AND EQUALS */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + year;
        long temp;
        temp = Double.doubleToLongBits(earned);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(withheld);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.result);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        TaxForms other = (TaxForms) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (year != other.year)
            return false;
        if (Double.doubleToLongBits(earned) != Double.doubleToLongBits(other.earned))
            return false;
        if (Double.doubleToLongBits(withheld) != Double.doubleToLongBits(other.withheld))
            return false;
        if (Double.doubleToLongBits(result) != Double.doubleToLongBits(other.result))
            return false;
        return true;
    }

    


}
