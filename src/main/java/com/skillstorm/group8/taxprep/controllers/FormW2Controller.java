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

import com.skillstorm.group8.taxprep.models.FormW2;

import com.skillstorm.group8.taxprep.services.FormW2Service;


@RestController
@RequestMapping("/formW2")
@CrossOrigin(origins = "http://localhost:5173")
public class FormW2Controller {

      /* ATTRIBUTES */

    @Autowired
    FormW2Service formW2Service;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all FormW2s
    @GetMapping
    public ResponseEntity<List<FormW2>> findAllFormW2() {
        List<FormW2> formW2 = formW2Service.findAllFormW2s();
        return new ResponseEntity<List<FormW2>>(formW2, HttpStatus.OK);
    }

    // Finds a user's tax forms by their email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<FormW2>> findFormW2ByEmail(@PathVariable String email) {
        List<FormW2> formW2 = formW2Service.findFormW2sByEmail(email);
        return new ResponseEntity<List<FormW2>>(formW2, HttpStatus.OK);
    }

    // Creates a new FormW2
    @PostMapping
    public ResponseEntity<FormW2> createFormW2(@Valid @RequestBody FormW2 formW2) {
        // Save the FormW2
        formW2Service.saveFormW2(formW2);
        return new ResponseEntity<FormW2>(formW2, HttpStatus.CREATED);
    }

    // Update FormW2
    @PutMapping
    public ResponseEntity<FormW2> updateFormW2(@Valid @RequestBody FormW2 updatedFormW2) {
        FormW2 updatedFormW2Result = formW2Service.updateFormW2(updatedFormW2);
        if (updatedFormW2Result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFormW2Result);
    }

    // Deletes a FormW2
    @DeleteMapping("/delete/{email}/{ein}")
    public ResponseEntity<FormW2> deleteFormW2(@PathVariable String email, @PathVariable String ein) {
       List<FormW2> formW2 = formW2Service.findFormW2sByEmail(email);
        for (FormW2 f : formW2) {
            if (f.getEmployerEIN().equals(ein)) {
                formW2Service.deleteFormW2(f);
            }
        }
        return ResponseEntity.noContent().build();
    }

}
