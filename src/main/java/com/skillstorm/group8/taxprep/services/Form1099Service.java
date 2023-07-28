package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.forms.Form1099;
import com.skillstorm.group8.taxprep.repositories.Form1099Repository;

@Service
public class Form1099Service {

    /* ATTRIBUTES */

    @Autowired
    private Form1099Repository form1099Repository;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all Form1099s
    public List<Form1099> findAllForm1099s() {
        return form1099Repository.findAll();
    }

    // Saves a Form1099
    public Form1099 saveForm1099(Form1099 form1099) {
        return form1099Repository.save(form1099);
    }

    // Deletes a Form1099
    public void deleteForm1099(Form1099 form1099) {
        form1099Repository.delete(form1099);
    }

    // Update a Form1099 with the provided updatedForm1099 object
    public Form1099 updateForm1099(String tin, Form1099 updatedForm1099) {
        // Find the existing Form1099 by TIN
        Optional<Form1099> optionalExistingForm1099 = form1099Repository.findByPayerTIN(tin);
        if (!optionalExistingForm1099.isPresent()) {
            return null;
        }
        Form1099 existingForm1099 = optionalExistingForm1099.get();
        // Manually update the Form1099 fields that are allowed to be updated
        if (updatedForm1099.getAmountWithheld() != 0.0) {
            existingForm1099.setAmountWithheld(updatedForm1099.getAmountWithheld());
        }
        if (updatedForm1099.getPayerFirstName() != null) {
            existingForm1099.setPayerFirstName(updatedForm1099.getPayerFirstName());
        }
        if (updatedForm1099.getPayerLastName() != null) {
            existingForm1099.setPayerLastName(updatedForm1099.getPayerLastName());
        }
        // Update other fields as needed...

        return form1099Repository.save(existingForm1099);
    }

    // Find a Form1099 by its TIN
    public Form1099 findForm1099ByTin(String tin) {
        Optional<Form1099> form1099 = form1099Repository.findByPayerTIN(tin);
        return form1099.orElse(null);
    }
}
