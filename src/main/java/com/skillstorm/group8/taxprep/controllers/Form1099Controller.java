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

import com.skillstorm.group8.taxprep.models.Form1099;
import com.skillstorm.group8.taxprep.services.Form1099Service;


@RestController
@RequestMapping("/form1099")
@CrossOrigin(origins = "http://localhost:5173")
public class Form1099Controller {

    /* ATTRIBUTES */

    @Autowired
    Form1099Service form1099Service;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all Form1099s
    @GetMapping
    public ResponseEntity<List<Form1099>> findAllForm1099() {
        List<Form1099> form1099 = form1099Service.findAllForm1099s();
        return new ResponseEntity<List<Form1099>>(form1099, HttpStatus.OK);
    }

    // Finds a user's tax forms by their email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Form1099>> findForm1099ByEmail(@PathVariable String email) {
        List<Form1099> form1099 = form1099Service.findForm1099sByEmail(email);
        return new ResponseEntity<List<Form1099>>(form1099, HttpStatus.OK);
    }

    // Creates a new Form1099
    @PostMapping
    public ResponseEntity<Form1099> createForm1099(@Valid @RequestBody Form1099 form1099) {
        // Save the Form1099
        form1099Service.saveForm1099(form1099);
        return new ResponseEntity<Form1099>(form1099, HttpStatus.CREATED);
    }

    // Update Form1099
    @PutMapping
    public ResponseEntity<Form1099> updateForm1099(@Valid @RequestBody Form1099 updatedForm1099) {
        Form1099 updatedForm1099Result = form1099Service.updateForm1099(updatedForm1099);
        if (updatedForm1099Result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedForm1099Result);
    }

    // Deletes a Form1099
    @DeleteMapping("/delete/{email}/{tin}")
    public ResponseEntity<Form1099> deleteForm1099( @PathVariable String email, @PathVariable String tin) {
        List<Form1099> form1099 = form1099Service.findForm1099sByEmail(email);
        for (Form1099 f : form1099) {
            if (f.getPayerTIN().equals(tin)) {
                form1099Service.deleteForm1099(f);
            }
        }
        return ResponseEntity.noContent().build();
    }
}
