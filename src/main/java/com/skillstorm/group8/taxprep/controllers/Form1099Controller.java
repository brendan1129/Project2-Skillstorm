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

import com.skillstorm.group8.taxprep.forms.Form1099;
import com.skillstorm.group8.taxprep.services.Form1099Service;

@RestController
@RequestMapping("/form1099s")
@CrossOrigin("*")
public class Form1099Controller {

    /* ATTRIBUTES */

    @Autowired
    private Form1099Service form1099Service;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all Form1099s
    @GetMapping
    public ResponseEntity<List<Form1099>> findAllForm1099s() {
        List<Form1099> form1099s = form1099Service.findAllForm1099s();
        return new ResponseEntity<>(form1099s, HttpStatus.OK);
    }

    // Creates a new Form1099
    @PostMapping("/form1099")
    public ResponseEntity<Form1099> createForm1099(@Valid @RequestBody Form1099 form1099) {
        Form1099 newForm1099 = form1099Service.saveForm1099(form1099);
        return new ResponseEntity<>(newForm1099, HttpStatus.CREATED);
    }

    // Deletes a Form1099
    @DeleteMapping("/{tin}")
    public ResponseEntity<Void> deleteForm1099(@PathVariable String tin) {
        Form1099 form1099 = form1099Service.findForm1099ByTin(tin);
        if (form1099 != null) {
            form1099Service.deleteForm1099(form1099);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Form1099 by TIN
    @PutMapping("/{tin}")
    public ResponseEntity<Form1099> updateForm1099(@PathVariable String tin, @Valid @RequestBody Form1099 updatedForm1099) {
        Form1099 updatedForm1099Result = form1099Service.updateForm1099(tin, updatedForm1099);
        if (updatedForm1099Result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedForm1099Result);
    }

}
