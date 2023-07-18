package com.skillstorm.group8.taxprep.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.skillstorm.group8.taxprep.IncomeSource.IncomeSource;
import com.skillstorm.group8.taxprep.forms.Form1099;
import com.skillstorm.group8.taxprep.forms.FormW2;

@Entity
@Table(name = "USERS")
public class User {

    /* ATTRIBUTES */

    // Primary key
    @Id
    @Column(name = "email", length = 50, unique = true)
    private String email;

    // Social Security Number
    @Column(name = "ssn", length = 11, unique = true)
    private String ssn;

    // User's first name
    @Column(name = "first_name")
    private String firstName;

    // User's last name
    @Column(name = "last_name")
    private String lastName;

    // User's password
    @Column(name = "password")
    private String password;

    // List of income from Form 1099
    @OneToMany
    @JoinColumn(name = "ssn")
    private List<Form1099> incomeFrom1099;

    // List of income from Form W2
    @OneToMany
    @JoinColumn(name = "ssn")
    private List<FormW2> incomeFromW2;

    // User's date of birth
    @Column(name = "dob")
    private Date dateOfBirth;

    // Address address; 

    // User's marital status
    @Column(name = "marital_status")
    private Enum<MaritalStatus> maritalStatus;

    /* CONSTRUCTORS */

    public User() {
        // Default constructor
    }

    /* GETTERS AND SETTERS */

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
}
