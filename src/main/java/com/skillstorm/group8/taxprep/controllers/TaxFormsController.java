package com.skillstorm.group8.taxprep.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.models.TaxForms;
import com.skillstorm.group8.taxprep.services.TaxFormsService;

@RestController
@RequestMapping("/taxforms")
@CrossOrigin(origins = "http://localhost:5173")
public class TaxFormsController {

    /* ATTRIBUTES */

    @Autowired
    TaxFormsService taxFormsService;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all TaxFormss
    @GetMapping
    public ResponseEntity<List<TaxForms>> findAllTaxForms() {
        List<TaxForms> taxForms = taxFormsService.findAllTaxForms();
        return new ResponseEntity<List<TaxForms>>(taxForms, HttpStatus.OK);
    }

    // Finds a user's tax forms by their email
    @GetMapping("/email/{email}")
    public ResponseEntity<TaxForms> findTaxFormsByEmail(@PathVariable String email) {
        TaxForms taxForm = taxFormsService.findTaxFormsByEmail(email);
        return new ResponseEntity<TaxForms>(taxForm, HttpStatus.OK);
    }

    // Creates a new TaxForms
    @PostMapping("/taxforms")
    public ResponseEntity<TaxForms> createTaxForms(@Valid @RequestBody TaxForms TaxForms) {
        // Save the TaxForms
        taxFormsService.saveTaxForms(TaxForms);
        return new ResponseEntity<TaxForms>(TaxForms, HttpStatus.CREATED);
    }

    // Update TaxForms
    @PutMapping("/taxforms")
    public ResponseEntity<TaxForms> updateTaxForms(@Valid @RequestBody TaxForms updatedTaxForms) {
        TaxForms updatedTaxFormsResult = taxFormsService.updateTaxForms(updatedTaxForms);
        if (updatedTaxFormsResult == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTaxFormsResult);
    }

    // Deletes a TaxForms
    @DeleteMapping("/email/{email}")
    public ResponseEntity<TaxForms> deleteTaxForms(@PathVariable String email) {
        taxFormsService.deleteTaxForms(email);
        return ResponseEntity.noContent().build();
    }

}
