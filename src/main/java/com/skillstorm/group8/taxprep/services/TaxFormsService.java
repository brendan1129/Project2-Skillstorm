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

    @Autowired
    TaxFormsRepository taxFormsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FormW2Repository formW2Repository;

    @Autowired
    Form1099Repository form1099Repository;


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

    public TaxForms taxCalculation (TaxForms taxForms) {
    double taxDue, bracket0, bracket1, bracket2, bracket3, bracket4, bracket5, earned = 0, withheld = 0;
    
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
            System.out.println(earned);
    }
    }

    if (all1099Forms.isPresent()) {
        for (Form1099 x : all1099Forms.get()) {
            earned += x.getAmountEarned();
            withheld += x.getAmountWithheld();
    }
    }

    if (status.equalsIgnoreCase("SINGLE")) {
        bracket0=11000.00;
        bracket1=44725.00; 
        bracket2=95375.00; 
        bracket3=182100.00; 
        bracket4=231250.00; 
        bracket5=578125.00;
    }

    else if (status.equalsIgnoreCase("MARRIED_FILING_SEPARATELY")){
        bracket0=11000.00;
        bracket1=44725.00; 
        bracket2=95375.00; 
        bracket3=182100.00; 
        bracket4=231250.00; 
        bracket5=346875.00;
    }

    else if (status.equalsIgnoreCase("HEAD_OF_HOUSEHOLD")){
        bracket0=15700.00;
        bracket1=59850.00; 
        bracket2=95350.00; 
        bracket3=182100.00; 
        bracket4=231250.00; 
        bracket5=578100.00;
    }

    else {
        bracket0=22000.00;
        bracket1=89450.00; 
        bracket2=190750.00; 
        bracket3=364200.00; 
        bracket4=462500.00; 
        bracket5=693750.00;
    }

    if (earned <= bracket0) {
        taxDue = (earned * .1);
    }
    else if (earned > bracket0 && earned <= bracket1) {
        taxDue = ((bracket0*.1) + ((earned - bracket0) *.12));
    }
    else if (earned > bracket1 && earned <= bracket2) {
        taxDue = ((bracket1*.12) + ((earned - bracket1) *.22));
    }
    else if (earned > bracket2 && earned <= bracket3) {
        taxDue = ((bracket2*.22) + ((earned - bracket2) *.24));
    }
    else if (earned > bracket3 && earned <= bracket4) {
        taxDue = ((bracket3*.24) + ((earned - bracket3) *.32));
    }
    else if (earned > bracket4 && earned <= bracket5) {
        taxDue = ((bracket4*.32) + ((earned - bracket4) *.35));
    }
    else {
        taxDue = ((bracket3*.35) + ((earned - bracket5) *.37));
    }

    taxForms.setYear(Year.now().getValue() - 1);
    taxForms.setEarned(earned);
    taxForms.setWithheld(withheld);
    taxForms.setResult(taxDue-withheld);

    return taxForms;
}
    
}
