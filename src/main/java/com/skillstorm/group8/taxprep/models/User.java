package com.skillstorm.group8.taxprep.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;



import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User implements Serializable {

    /* ATTRIBUTES */

    // Email
    @Id
    private String email;

    // Primary key
    // Social Security Number
    
    private String ssn;

    // User's first name
    private String firstName;

    // User's last name
    private String lastName;

    // User's password
    private String password;

    private Address address;

    private Date dateOfBirth;

    private MaritalStatus maritalStatus;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public User(String email, String ssn, String firstName, String lastName, String password, Address address,
            Date dateOfBirth, MaritalStatus maritalStatus) {
        this.email = email;
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName
                + ", password=" + password + ", address=" + address + ", dateOfBirth=" + dateOfBirth
                + ", maritalStatus=" + maritalStatus + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
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
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (maritalStatus != other.maritalStatus)
            return false;
        return true;
    }

    
}
