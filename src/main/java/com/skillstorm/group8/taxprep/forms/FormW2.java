package com.skillstorm.group8.taxprep.forms;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.skillstorm.group8.taxprep.IncomeSource.IncomeSource;
import com.skillstorm.group8.taxprep.models.User;

@Document(collection = "FormW2s")
public class FormW2 extends IncomeSource {

    /* ATTRIBUTES */

    // Employer's Employer Identification Number (EIN)
    @Id
    private String employerEIN;

    // Amount withheld from income
    private double amountWithheld;

    // Payer's first name
    private String payerFirstName;

    // Payer's last name
    private String payerLastName;

    // Reference to the user who filled the form
    private User user;


    /* CONSTRUCTORS */

    public FormW2() {
        // Default Constructor
    }

    /* GETTERS AND SETTERS */

    public String getEmployerEIN() {
        return employerEIN;
    }

    public void setEmployerEIN(String employerEIN) {
        this.employerEIN = employerEIN;
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
