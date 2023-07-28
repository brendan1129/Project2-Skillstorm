package com.skillstorm.group8.taxprep.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.forms.FormW2;
import com.skillstorm.group8.taxprep.services.FormW2Service;

@RestController
@RequestMapping("/formw2s")
@CrossOrigin("*")
public class FormW2Controller {

    /* ATTRIBUTES */

    @Autowired
    private FormW2Service formW2Service;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all FormW2s
    @GetMapping
    public ResponseEntity<List<FormW2>> findAllFormW2s() {
        List<FormW2> formW2s = formW2Service.findAllFormW2s();
        return new ResponseEntity<>(formW2s, HttpStatus.OK);
    }

    // Creates a new FormW2
    @PostMapping("/formw2")
    public ResponseEntity<FormW2> createFormW2(@Valid @RequestBody FormW2 formW2) {
        FormW2 newFormW2 = formW2Service.saveFormW2(formW2);
        return new ResponseEntity<>(newFormW2, HttpStatus.CREATED);
    }

    // Deletes a FormW2
    @DeleteMapping("/{ein}")
    public ResponseEntity<Void> deleteFormW2(@PathVariable String ein) {
        FormW2 formW2 = formW2Service.findFormW2ByEin(ein);
        if (formW2 != null) {
            formW2Service.deleteFormW2(formW2);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a FormW2 by EIN
    @PutMapping("/{ein}")
    public ResponseEntity<FormW2> updateFormW2(@PathVariable String ein, @Valid @RequestBody FormW2 updatedFormW2) {
        FormW2 updatedFormW2Result = formW2Service.updateFormW2(ein, updatedFormW2);
        if (updatedFormW2Result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFormW2Result);
    }

}
