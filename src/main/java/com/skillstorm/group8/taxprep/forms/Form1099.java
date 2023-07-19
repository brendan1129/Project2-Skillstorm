package com.skillstorm.group8.taxprep.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.skillstorm.group8.taxprep.IncomeSource.IncomeSource;
import com.skillstorm.group8.taxprep.models.Address;

@Entity
@Table(name = "Form1099s")
public class Form1099 extends IncomeSource {

    /* ATTRIBUTES */

    // Payer's Tax Identification Number (TIN)
    @Id
    @Column(name = "TIN", length = 9)
    private String payerTIN;

    // Amount withheld from income
    @Column(name = "withheld")
    private double amountWithheld;

    //Address employerAddress;

    // Employer's name
    @Column(name = "name")
    private String employerName;

    /* CONSTRUCTORS */

    public Form1099() {
        // Default constructor
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

    // public Address getEmployerAddress() {
    //     return employerAddress;
    // }

    // public void setEmployerAddress(Address employerAddress) {
    //     this.employerAddress = employerAddress;
    // }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

}
