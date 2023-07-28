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
@Table(name = "FormW2s")
public class FormW2 extends IncomeSource {

    /* ATTRIBUTES */

    // Employer's Employer Identification Number (EIN)
    @Id
    @Column(name = "ein", length = 10)
    private String employerEIN;

    // Amount withheld from income
    @Column(name = "withheld")
    private double amountWithheld;

    // Payer's first name
    @Column(name = "first_name")
    private String payerFirstName;

    // Payer's last name
    @Column(name = "last_name")
    private String payerLastName;

    // Reference to the user who filled the form
    @ManyToOne
    @JoinColumn(name = "ssn", referencedColumnName = "ssn")
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
