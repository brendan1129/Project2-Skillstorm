package com.skillstorm.group8.taxprep.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.skillstorm.group8.taxprep.models.TaxForms;
import com.skillstorm.group8.taxprep.repositories.TaxFormsRepository;

@Service
public class TaxFormsService {

    @Autowired
    TaxFormsRepository taxFormsRepository;

    // Retrieves a list of all tax forms
    public List<TaxForms> findAllTaxForms() {
        return taxFormsRepository.findAll();
    }

    // retrieves tax forms by user's email/log in
    public TaxForms findTaxFormsByEmail(String email) {
        Optional<TaxForms> taxForms = taxFormsRepository.findTaxFormsByEmail(email);
        if (taxForms.isPresent())
            return taxForms.get();
        return null;
    }

    // saves new tax forms
    public TaxForms saveTaxForms (TaxForms taxForms) {
        taxForms = taxFormsRepository.save(taxForms);
       // taxForms = taxForms.taxCalculation(taxForms);
        return taxForms;
    }

    // updates existing tax forms
    public TaxForms updateTaxForms(TaxForms taxForms) {

        // Find the existing tax forms by user email
        String email = taxForms.getEmail();
        Optional<TaxForms> optionalExistingTaxForms = taxFormsRepository.findTaxFormsByEmail(email);
        if (!optionalExistingTaxForms.isPresent()) {
            return null;
        }
        
        // checks to make sure the user is editing the current tax year
        Calendar cal = Calendar.getInstance();
        int currentTaxYear = (cal.get(Calendar.YEAR) - 1);
        TaxForms existingTaxForms = optionalExistingTaxForms.get();
        if (existingTaxForms.getYear() != currentTaxYear) {
            return null;
        }
        existingTaxForms = taxForms.taxCalculation(taxForms);
        return taxFormsRepository.save(existingTaxForms);
    }

    public void deleteTaxForms(String email) {
         Optional<TaxForms> optionalExistingTaxForms = taxFormsRepository.findTaxFormsByEmail(email);
        if (!optionalExistingTaxForms.isPresent()) {
            return;
        }
        taxFormsRepository.delete(optionalExistingTaxForms.get());
    }
    
}
