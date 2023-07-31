package com.skillstorm.group8.taxprep.forms;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.skillstorm.group8.taxprep.IncomeSource.IncomeSource;
import com.skillstorm.group8.taxprep.models.User;

@Document(collection = "Form1099s")
public class Form1099 extends IncomeSource {

    /* ATTRIBUTES */

    // Payer's Tax Identification Number (TIN)
    @Id
    private String payerTIN;

    // Amount withheld from income
    private double amountWithheld;

    // Employer's first name
    private String payerFirstName;

    // Employer's last name
    private String payerLastName;

    // Reference to the user who filled the form
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
