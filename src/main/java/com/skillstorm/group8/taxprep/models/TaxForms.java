package com.skillstorm.group8.taxprep.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.skillstorm.group8.taxprep.services.UserService;

@Document(collection="taxforms")
public class TaxForms {

    @Autowired
    UserService userService;

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

    // List of user's 1099 forms
    List<Form1099> form1099s = new ArrayList<Form1099>();

    // List of user's W2 forms
    List<FormW2>formW2s = new ArrayList<FormW2>();


    /* CONSTRUCTORS */

    public TaxForms() {
        // Default constructor
    }


    public TaxForms(String email, int year, List<Form1099> form1099s, List<FormW2> formW2s) {
        this.email = email;
        this.year = year;
        this.form1099s = form1099s;
        this.formW2s = formW2s;
    }


    public TaxForms(String email, int year, double earned, double withheld, double result, List<Form1099> form1099s,
            List<FormW2> formW2s) {
        this.email = email;
        this.year = year;
        this.earned = earned;
        this.withheld = withheld;
        this.result = result;
        this.form1099s = form1099s;
        this.formW2s = formW2s;
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


    public List<Form1099> getForm1099s() {
        return form1099s;
    }


    public void setForm1099s(List<Form1099> form1099s) {
        this.form1099s = form1099s;
    }


    public List<FormW2> getFormW2s() {
        return formW2s;
    }


    public void setFormW2s(List<FormW2> formW2s) {
        this.formW2s = formW2s;
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
        result = prime * result + ((form1099s == null) ? 0 : form1099s.hashCode());
        result = prime * result + ((formW2s == null) ? 0 : formW2s.hashCode());
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
        if (form1099s == null) {
            if (other.form1099s != null)
                return false;
        } else if (!form1099s.equals(other.form1099s))
            return false;
        if (formW2s == null) {
            if (other.formW2s != null)
                return false;
        } else if (!formW2s.equals(other.formW2s))
            return false;
        return true;
    }

    
public TaxForms taxCalculation (TaxForms taxForms) {
    double taxDue, bracket0, bracket1, bracket2, bracket3, bracket4, bracket5, earned = 0, withheld = 0;

    for (FormW2 w : taxForms.getFormW2s()) {
        earned += w.getAmountEarned();
        withheld += w.getAmountWithheld();
    }

    for (Form1099 x : taxForms.getForm1099s()) {
        earned += x.getAmountEarned();
        withheld += x.getAmountWithheld();
    }

    User user = userService.findUserByEmail(taxForms.getEmail());
    MaritalStatus status = user.getMaritalStatus();

    if (status.name().equalsIgnoreCase("SINGLE")) {
        bracket0=11000.00;
        bracket1=44725.00; 
        bracket2=95375.00; 
        bracket3=182100.00; 
        bracket4=231250.00; 
        bracket5=578125.00;
    }

    else if (status.name().equalsIgnoreCase("MARRIED_FILING_SEPARATELY")){
        bracket0=11000.00;
        bracket1=44725.00; 
        bracket2=95375.00; 
        bracket3=182100.00; 
        bracket4=231250.00; 
        bracket5=346875.00;
    }

    else if (status.name().equalsIgnoreCase("HEAD_OF_HOUSEHOLD")){
        bracket0=15700.00;
        bracket1=59850.00; 
        bracket2=95350.00; 
        bracket3=182100.00; 
        bracket4=231250.00; 
        bracket5=578100.00;
    }

    else {
        bracket0=22000.00;
        bracket1=89450.00; 
        bracket2=190750.00; 
        bracket3=364200.00; 
        bracket4=462500.00; 
        bracket5=693750.00;
    }

    if (earned <= bracket0) {
        taxDue = (earned * .1);
    }
    else if (earned > bracket0 && earned <= bracket1) {
        taxDue = ((bracket0*.1) + ((earned - bracket0) *.12));
    }
    else if (earned > bracket1 && earned <= bracket2) {
        taxDue = ((bracket1*.12) + ((earned - bracket1) *.22));
    }
    else if (earned > bracket2 && earned <= bracket3) {
        taxDue = ((bracket2*.22) + ((earned - bracket2) *.24));
    }
    else if (earned > bracket3 && earned <= bracket4) {
        taxDue = ((bracket3*.24) + ((earned - bracket3) *.32));
    }
    else if (earned > bracket4 && earned <= bracket5) {
        taxDue = ((bracket4*.32) + ((earned - bracket4) *.35));
    }
    else {
        taxDue = ((bracket3*.35) + ((earned - bracket5) *.37));
    }

    taxForms.setResult(taxDue-withheld);

    return taxForms;
}

}
