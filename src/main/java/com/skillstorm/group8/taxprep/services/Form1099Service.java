package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Form1099;
import com.skillstorm.group8.taxprep.models.TaxForms;
import com.skillstorm.group8.taxprep.repositories.Form1099Repository;
import com.skillstorm.group8.taxprep.repositories.TaxFormsRepository;

@Service
public class Form1099Service {

    @Autowired
    Form1099Repository form1099Repository;

     @Autowired
    TaxFormsRepository taxFormsRepository;

    @Autowired
    TaxFormsService taxFormsService;

    // Retrieves a list of all 1099 forms
    public List<Form1099> findAllForm1099s() {
        return form1099Repository.findAll();
    }

    // retrieves 1099 forms by user's email/log in
    public List<Form1099> findForm1099sByEmail(String email) {
        Optional<List<Form1099>> form1099s = form1099Repository.findForm1099sByEmail(email);
        if (form1099s.isPresent())
            return form1099s.get();
        return null;
    }

    // saves new 1099s
    public Form1099 saveForm1099 (Form1099 form1099) {
        Form1099 newForm1099 = form1099Repository.save(form1099);

        // checks for an existing tax form, makes one if not present, and then updates tax totals with info from the new form
         Optional<TaxForms> optionalExistingTaxForms = taxFormsRepository.findTaxFormsByEmail(form1099.getEmail());
        if (!optionalExistingTaxForms.isPresent()) {
            setTimeout(() -> {
                TaxForms taxForms = new TaxForms(form1099.getEmail());
                taxForms = taxFormsRepository.save(taxFormsService.taxCalculation(taxForms));
            }, 500);
        }
        else {
            setTimeout(() -> {
                taxFormsRepository.save(taxFormsService.taxCalculation(optionalExistingTaxForms.get()));
            }, 500);
        }
        return newForm1099;
    }

    // updates existing 1099s
    public Form1099 updateForm1099(Form1099 form1099) {

        // Find the existing tax forms by user email
        String ptin = form1099.getPayerTIN();
        Optional<Form1099> optionalExistingForm1099 = form1099Repository.findForm1099sByPayerTIN(ptin);
        if (!optionalExistingForm1099.isPresent()) {
            return null;
        }

        // updates the 1099 in the database
        Form1099 existingForm1099 = form1099Repository.save(form1099);

        // recalculates the total tax amounts based on the new updates
        setTimeout(() -> {
            Optional<TaxForms> taxForm = taxFormsRepository.findTaxFormsByEmail(form1099.getEmail());
            taxFormsRepository.save(taxFormsService.taxCalculation(taxForm.get()));
        }, 500);

        return existingForm1099;
    }
    // deletes an existing 1099 form
    public void deleteForm1099(Form1099 form1099) {
        form1099Repository.delete(form1099);

        // recalculates the total tax amounts after 1099 deletion
        setTimeout(() -> {
            Optional<TaxForms> taxForm = taxFormsRepository.findTaxFormsByEmail(form1099.getEmail());
            taxFormsRepository.save(taxFormsService.taxCalculation(taxForm.get()));
        }, 500);
    }

    // small timeout to ensure database updates
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
    
}
