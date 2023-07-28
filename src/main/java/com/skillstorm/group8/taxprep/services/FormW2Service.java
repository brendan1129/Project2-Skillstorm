package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.forms.FormW2;
import com.skillstorm.group8.taxprep.repositories.FormW2Repository;

@Service
public class FormW2Service {

    /* ATTRIBUTES */

    @Autowired
    private FormW2Repository formW2Repository;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all FormW2s
    public List<FormW2> findAllFormW2s() {
        return formW2Repository.findAll();
    }

    // Saves a FormW2
    public FormW2 saveFormW2(FormW2 formW2) {
        return formW2Repository.save(formW2);
    }

    // Deletes a FormW2
    public void deleteFormW2(FormW2 formW2) {
        formW2Repository.delete(formW2);
    }

    // Update a FormW2 with the provided updatedFormW2 object
    public FormW2 updateFormW2(String ein, FormW2 updatedFormW2) {
        // Find the existing FormW2 by EIN
        Optional<FormW2> optionalExistingFormW2 = formW2Repository.findByEmployerEIN(ein);
        if (!optionalExistingFormW2.isPresent()) {
            return null;
        }
        FormW2 existingFormW2 = optionalExistingFormW2.get();
        // Manually update the FormW2 fields that are allowed to be updated
        if (updatedFormW2.getAmountWithheld() != 0.0) {
            existingFormW2.setAmountWithheld(updatedFormW2.getAmountWithheld());
        }
        if (updatedFormW2.getPayerFirstName() != null) {
            existingFormW2.setPayerFirstName(updatedFormW2.getPayerFirstName());
        }
        if (updatedFormW2.getPayerLastName() != null) {
            existingFormW2.setPayerLastName(updatedFormW2.getPayerLastName());
        }
        // Update other fields as needed...

        return formW2Repository.save(existingFormW2);
    }

    // Find a FormW2 by its EIN
    public FormW2 findFormW2ByEin(String ein) {
        Optional<FormW2> formW2 = formW2Repository.findByEmployerEIN(ein);
        return formW2.orElse(null);
    }
}
