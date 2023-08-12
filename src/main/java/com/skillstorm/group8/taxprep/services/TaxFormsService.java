package com.skillstorm.group8.taxprep.services;

import java.time.Year;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Form1099;
import com.skillstorm.group8.taxprep.models.FormW2;
import com.skillstorm.group8.taxprep.models.TaxForms;
import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.repositories.Form1099Repository;
import com.skillstorm.group8.taxprep.repositories.FormW2Repository;
import com.skillstorm.group8.taxprep.repositories.TaxFormsRepository;
import com.skillstorm.group8.taxprep.repositories.UserRepository;

@Service
public class TaxFormsService {

    /* ATTRIBUTES */

    @Autowired
    TaxFormsRepository taxFormsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FormW2Repository formW2Repository;

    @Autowired
    Form1099Repository form1099Repository;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all tax forms
    public List<TaxForms> findAllTaxForms() {
        return taxFormsRepository.findAll();
    }

    // saves new tax forms
    public TaxForms saveTaxForms (TaxForms taxForms) {
        taxForms = taxFormsRepository.save(taxForms);
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
        // existingTaxForms = taxForms.taxCalculation(taxForms);
        return taxFormsRepository.save(existingTaxForms);
    }

    public void deleteTaxForms(String email) {
         Optional<TaxForms> optionalExistingTaxForms = taxFormsRepository.findTaxFormsByEmail(email);
        if (!optionalExistingTaxForms.isPresent()) {
            return;
        }
        taxFormsRepository.delete(optionalExistingTaxForms.get());
    }

    /* ADDITIONAL METHODS */

    // retrieves tax forms by user's email/log in
    public TaxForms findTaxFormsByEmail(String email) {
        Optional<TaxForms> taxForms = taxFormsRepository.findTaxFormsByEmail(email);
        if (taxForms.isPresent())
            return taxForms.get();
        return null;
    }


    /* TAX CALCULATION */

    public TaxForms taxCalculation (TaxForms taxForms) {

        
        double taxDue, earned = 0, withheld = 0;
        taxForms.setEarned(earned);
        taxForms.setWithheld(withheld);
        
        User user = new User();
        Optional<User> optionalUser = userRepository.findByEmail(taxForms.getEmail());
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        String status = user.getMaritalStatus();
        Optional<List<FormW2>> allW2Forms = formW2Repository.findFormW2sByEmail(user.getEmail());
        Optional<List<Form1099>> all1099Forms = form1099Repository.findForm1099sByEmail(user.getEmail());

        if (allW2Forms.isPresent()) {
            for (FormW2 w : allW2Forms.get()) {
                earned += w.getAmountEarned();
                withheld += w.getAmountWithheld();
        }
        }

        if (all1099Forms.isPresent()) {
            for (Form1099 x : all1099Forms.get()) {
                earned += x.getAmountEarned();
                withheld += x.getAmountWithheld();
        }
        }

        if (status.equalsIgnoreCase("SINGLE")) {
        if (earned <= 11000.00) {
                taxDue = (earned * .1);
            }
            else if (earned > 11000.00 && earned <= 44725.00) {
                taxDue = ((1100.00) + ((earned - 11000.00) *.12));
            }
            else if (earned > 44725.00 && earned <= 95375.00) {
                taxDue = ((5147.00) + ((earned - 44725.00) *.22));
            }
            else if (earned > 95375.00 && earned <= 182100.00) {
                taxDue = ((16290.00) + ((earned - 95375.00) *.24));
            }
            else if (earned > 182100.00 && earned <= 231250.00) {
                taxDue = ((37104.00) + ((earned - 182100.00) *.32));
            }
            else if (earned > 231250.00 && earned <= 578125.00) {
                taxDue = ((52832.00) + ((earned - 231250.00) *.35));
            }
            else {
                taxDue = ((174238.25) + ((earned - 578125.00) *.37));
            }
        }

        else if (status.equalsIgnoreCase("MARRIED_FILING_SEPARATELY")){
            if (earned <= 11000.00) {
                taxDue = (earned * .1);
            }
            else if (earned > 11000.00 && earned <= 44725.00) {
                taxDue = ((1100.00) + ((earned - 11000.00) *.12));
            }
            else if (earned > 44725.00 && earned <= 95375.00) {
                taxDue = ((5147.00) + ((earned - 44725.00) *.22));
            }
            else if (earned > 95375.00 && earned <= 182100.00) {
                taxDue = ((16290.00) + ((earned - 95375.00) *.24));
            }
            else if (earned > 182100.00 && earned <= 231250.00) {
                taxDue = ((37104.00) + ((earned - 182100.00) *.32));
            }
            else if (earned > 231250.00 && earned <= 346875.00) {
                taxDue = ((52832.00) + ((earned - 231250.00) *.35));
            }
            else {
                taxDue = ((93300.75) + ((earned - 346875.00) *.37));
            }
        }

        else if (status.equalsIgnoreCase("HEAD_OF_HOUSEHOLD")){
            if (earned <= 15700.00) {
                taxDue = (earned * .1);
            }
            else if (earned > 15700.00 && earned <= 59850.00) {
                taxDue = ((1570.00) + ((earned - 15700.00) *.12));
            }
            else if (earned > 59850.00 && earned <= 95350.00) {
                taxDue = ((6868.00) + ((earned - 59850.00) *.22));
            }
            else if (earned > 953505.00 && earned <= 182100.00) {
                taxDue = ((14678.00) + ((earned - 95350.00) *.24));
            }
            else if (earned > 182100.00 && earned <= 231250.00) {
                taxDue = ((35498.00) + ((earned - 182100.00) *.32));
            }
            else if (earned > 231250.00 && earned <= 578100.00) {
                taxDue = ((51226.00) + ((earned - 231250.00) *.35));
            }
            else {
                taxDue = ((172623.50) + ((earned - 578100.00) *.37));
            }
        }

        else {
            if (earned <= 22000.00) {
                taxDue = (earned * .1);
            }
            else if (earned > 22000.00 && earned <= 89450.00) {
                taxDue = ((2200.00) + ((earned - 22000.00) *.12));
            }
            else if (earned > 89450.00 && earned <= 190750.00) {
                taxDue = ((10294.00) + ((earned - 89450.00) *.22));
            }
            else if (earned > 190750.00 && earned <= 364200.00) {
                taxDue = ((32580.00) + ((earned - 190750.00) *.24));
            }
            else if (earned > 364200.00 && earned <= 462500.00) {
                taxDue = ((74208.00) + ((earned - 364200.00) *.32));
            }
            else if (earned > 462500.00 && earned <= 693750.00) {
                taxDue = ((105664.00) + ((earned - 462500.00) *.35));
            }
            else {
                taxDue = ((186601.50) + ((earned - 693750.00) *.37));
            }
        }

        taxForms.setYear(Year.now().getValue() - 1);
        taxForms.setEarned(earned);
        taxForms.setWithheld(withheld);
        taxForms.setResult(taxDue-withheld);

        return taxForms;
    }

    

    
    
}
