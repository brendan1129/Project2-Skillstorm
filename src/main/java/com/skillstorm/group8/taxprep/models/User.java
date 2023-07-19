package com.skillstorm.group8.taxprep.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillstorm.group8.taxprep.forms.Form1099;
import com.skillstorm.group8.taxprep.forms.FormW2;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "ssn", length = 11, unique = true)
    private String ssn;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "ssn")
    private List<Form1099> incomeFrom1099;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ssn")
    private List<FormW2> incomeFromW2;

    // Address address;

    // @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "marital_status")
    private Enum<MaritalStatus> maritalStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Form1099> getIncomeFrom1099() {
        return incomeFrom1099;
    }

    public void setIncomeFrom1099(List<Form1099> incomeFrom1099) {
        this.incomeFrom1099 = incomeFrom1099;
    }

    public List<FormW2> getIncomeFromW2() {
        return incomeFromW2;
    }

    public void setIncomeFromW2(List<FormW2> incomeFromW2) {
        this.incomeFromW2 = incomeFromW2;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Enum<MaritalStatus> getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Enum<MaritalStatus> maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    // public Address getAddress() {
    // return address;
    // }

    // public void setAddress(Address address) {
    // this.address = address;
    // }

}
