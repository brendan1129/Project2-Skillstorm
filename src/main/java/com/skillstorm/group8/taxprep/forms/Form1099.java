package com.skillstorm.group8.taxprep.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skillstorm.group8.taxprep.IncomeSource.IncomeSource;
import com.skillstorm.group8.taxprep.models.User;

@Entity
@Table(name = "Form1099s")
public class Form1099 extends IncomeSource {

    /* ATTRIBUTES */

    // Payer's Tax Identification Number (TIN)
    @Id
    @Column(name = "tin", length = 9)
    private String payerTIN;

    // Amount withheld from income
    @Column(name = "withheld")
    private double amountWithheld;

    // Employer's first name
    @Column(name = "first_name")
    private String payerFirstName;

    // Employer's last name
    @Column(name = "last_name")
    private String payerLastName;

    // Reference to the user who filled the form
    @ManyToOne
    @JoinColumn(name = "ssn", referencedColumnName = "ssn")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
