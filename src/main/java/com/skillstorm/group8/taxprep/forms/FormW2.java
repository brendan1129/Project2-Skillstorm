package com.skillstorm.group8.taxprep.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.skillstorm.group8.taxprep.IncomeSource.IncomeSource;
import com.skillstorm.group8.taxprep.models.Address;

@Entity
@Table(name = "FormW2s")
public class FormW2 extends IncomeSource {

    @Id
    @Column(name = "EIN", length = 10)
    private String employerEIN;

    @Column(name = "withheld")
    private double amountWithheld;

    //Address payerAddress;

    @Column(name = "first_name")
    String payerFirstName;

    @Column(name = "last_name")
    String payerLastName;

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

    // public Address getPayerAddress() {
    //     return payerAddress;
    // }

    // public void setPayerAddress(Address payerAddress) {
    //     this.payerAddress = payerAddress;
    // }

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

}
