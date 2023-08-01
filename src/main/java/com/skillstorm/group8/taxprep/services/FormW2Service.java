package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.FormW2;
import com.skillstorm.group8.taxprep.models.TaxForms;
import com.skillstorm.group8.taxprep.repositories.FormW2Repository;
import com.skillstorm.group8.taxprep.repositories.TaxFormsRepository;

@Service
public class FormW2Service {

    @Autowired
    FormW2Repository formW2Repository;

    @Autowired
    TaxFormsRepository taxFormsRepository;

    @Autowired
    TaxFormsService taxFormsService;

    // Retrieves a list of all W2 forms
    public List<FormW2> findAllFormW2s() {
        return formW2Repository.findAll();
    }

    // retrieves W2 forms by user's email/log in
    public List<FormW2> findFormW2sByEmail(String email) {
        Optional<List<FormW2>> formW2s = formW2Repository.findFormW2sByEmail(email);
        if (formW2s.isPresent())
            return formW2s.get();
        return null;
    }

    // saves new W2s
    public FormW2 saveFormW2 (FormW2 formW2) {
        FormW2 newFormW2 = formW2Repository.save(formW2);

        // checks for an existing tax form, makes one if not present, and then updates tax totals with info from the new form
         Optional<TaxForms> optionalExistingTaxForms = taxFormsRepository.findTaxFormsByEmail(formW2.getEmail());
        if (!optionalExistingTaxForms.isPresent()) {
            TaxForms taxForms = new TaxForms(formW2.getEmail());
            taxForms = taxFormsRepository.save(taxFormsService.taxCalculation(taxForms));
        }
        else {
            taxFormsRepository.save(taxFormsService.taxCalculation(optionalExistingTaxForms.get()));
        }
        return newFormW2;
    }

    // updates existing W2s
    public FormW2 updateFormW2(FormW2 formW2) {

        // Find the existing W2 form by employer's EIN
        String ein = formW2.getEmployerEIN();
        Optional<FormW2> optionalExistingFormW2 = formW2Repository.findFormW2sByEmployerEIN(ein);
        if (!optionalExistingFormW2.isPresent()) {
            return null;
        }

        // updates the W2 in the database
        FormW2 existingFormW2 = formW2Repository.save(formW2);

        // recalculates the total tax amounts based on the new updates
        Optional<TaxForms> taxForm = taxFormsRepository.findTaxFormsByEmail(formW2.getEmail());
        taxFormsRepository.save(taxFormsService.taxCalculation(taxForm.get()));

        return existingFormW2;
    }

    // deletes an existing W2
    public void deleteFormW2(FormW2 formW2) {
        formW2Repository.delete(formW2);

        // recalculates the total tax amounts after W2 deletion
        Optional<TaxForms> taxForm = taxFormsRepository.findTaxFormsByEmail(formW2.getEmail());
        taxFormsRepository.save(taxFormsService.taxCalculation(taxForm.get()));
    }
    
}
